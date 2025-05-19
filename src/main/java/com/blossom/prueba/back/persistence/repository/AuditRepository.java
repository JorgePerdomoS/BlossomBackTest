package com.blossom.prueba.back.persistence.repository;

import com.blossom.prueba.back.persistence.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Integer> {
}
