package com.fiap.cliente.api.converter;


import com.fiap.cliente.api.request.EnderecoRequestDTO;
import com.fiap.cliente.api.request.ClienteRequestDTO;
import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import com.fiap.cliente.infrastructure.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClienteConverter {



    public ClienteEntity paraClienteEntity(ClienteRequestDTO clienteDTO) {
        return ClienteEntity.builder()
                .id(UUID.randomUUID().toString())
                .nome(clienteDTO.getNome())
                .documento(clienteDTO.getDocumento())
                .email(clienteDTO.getEmail())
                .dataCadastro(LocalDateTime.now())
                .build();

    }


    public EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoDTO, String clienteId) {
        return EnderecoEntity.builder()
                .rua(enderecoDTO.getRua())
                .bairro(enderecoDTO.getBairro())
                .clienteId(clienteId)
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .build();
    }

}
