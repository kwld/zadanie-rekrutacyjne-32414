package com.ksiegarnia.app.proces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    private final ProcessManagerService processManagerService;

    @Autowired
    public ProcessController(ProcessManagerService processManagerService) {
        this.processManagerService = processManagerService;
    }

    @GetMapping("/proces")
    public ResponseEntity<ProcessStatus> handleProcess() {
        ProcessStatus status = processManagerService.runOrGetStatus();
        return ResponseEntity.ok(status);
    }
}