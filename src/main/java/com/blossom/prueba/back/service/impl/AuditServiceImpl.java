package com.blossom.prueba.back.service.impl;

import com.blossom.prueba.back.domain.WeatherDTO;
import com.blossom.prueba.back.persistence.entity.AuditEntity;
import com.blossom.prueba.back.persistence.repository.AuditRepository;
import com.blossom.prueba.back.service.AuditService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public void saveAudit(String city, String status, String source, String error) {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setCity(city);
        auditEntity.setTimestamp(new Timestamp(System.currentTimeMillis()));
        auditEntity.setStatus(status);
        auditEntity.setSource(source);
        auditEntity.setError(error);
        auditRepository.save(auditEntity);
    }
}
