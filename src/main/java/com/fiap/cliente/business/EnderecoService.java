package com.fiap.cliente.business;

import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import com.fiap.cliente.infrastructure.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;


    public EnderecoEntity salvaEndereco(EnderecoEntity enderecoEntity) {
        return enderecoRepository.save(enderecoEntity);
    }

    public EnderecoEntity findByClienteId(String clienteId) {
        return enderecoRepository.findByClienteId(clienteId);
    }

    public void deleteByClienteId(String clienteId) {
        enderecoRepository.deleteByClienteId(clienteId);
    }


}
