package com.blossom.prueba.back.service;

import org.springframework.stereotype.Service;

@Service
public interface AuditService {
    void saveAudit(String city, String status, String source, String error);
}
