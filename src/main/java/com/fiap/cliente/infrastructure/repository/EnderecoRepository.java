package com.fiap.cliente.infrastructure.repository;

import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EnderecoRepository extends MongoRepository<EnderecoEntity, String> {

    EnderecoEntity findByClienteId(String clienteId);

    @Transactional
    void deleteByClienteId(String clienteId);
}
