package com.ksiegarnia.app.proces;

// Klasa do reprezentowania statusu w odpowiedzi JSON
public record ProcessStatus(
    String status,         // np. "STARTED", "RUNNING"
    Long processId,        // PID procesu
    Long duration          // Czas trwania w milisekundach (ms)
) {}