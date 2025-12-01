package com.ksiegarnia.app.proces;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProcessManagerService {

    private final AtomicReference<Process> currentProcessRef = new AtomicReference<>(null);
    private volatile Instant startTime;
    private final int DURATION_SECONDS = 60;

    public ProcessStatus runOrGetStatus() {
        Process activeProcess = currentProcessRef.get();
        if (activeProcess != null && activeProcess.isAlive()) {
            return getRunningStatus(activeProcess);
        }

        if (activeProcess != null && !activeProcess.isAlive()) {
             currentProcessRef.set(null); 
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("sleep", String.valueOf(DURATION_SECONDS));

            Process newProcess = pb.start();
            
            if (currentProcessRef.compareAndSet(null, newProcess)) {
                startTime = Instant.now();
                long pid = newProcess.pid(); 
                
                System.out.println("'sleep' start. PID: " + pid);
                
                new Thread(() -> {
                    try {
                        newProcess.waitFor();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        currentProcessRef.set(null);
                        System.out.println("'sleep' (PID: " + pid + ") end.");
                    }
                }).start();

                return new ProcessStatus("STARTED", pid, 0L); 
            }

            return getRunningStatus(currentProcessRef.get());

        } catch (IOException e) {
            System.err.println("Błąd: " + e.getMessage());

            return new ProcessStatus("ERROR", -1L, -1L);
        }
    }
    
    private ProcessStatus getRunningStatus(Process activeProcess) {
        if (activeProcess == null || startTime == null) {
            return new ProcessStatus("ERROR", -1L, -1L);
        }
        
        Duration duration = Duration.between(startTime, Instant.now());

        Long durationMs = duration.toMillis();
                                              
        return new ProcessStatus("RUNNING", activeProcess.pid(), durationMs);
    }
}