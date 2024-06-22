package com.fiap.cliente.infrastructure.repository;

import com.fiap.cliente.infrastructure.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

    ClienteEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
