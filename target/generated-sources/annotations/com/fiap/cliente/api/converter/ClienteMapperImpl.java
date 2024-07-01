package com.fiap.cliente.api.converter;

import com.fiap.cliente.api.response.ClienteResponseDTO;
import com.fiap.cliente.api.response.EnderecoResponseDTO;
import com.fiap.cliente.infrastructure.entity.ClienteEntity;
import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T15:15:58-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Azul Systems, Inc.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteResponseDTO paraClienteResponseDTO(ClienteEntity cliente, EnderecoEntity enderecoEntity) {
        if ( cliente == null && enderecoEntity == null ) {
            return null;
        }

        String id = null;
        String cpf = null;
        String nome = null;
        String documento = null;
        String email = null;
        if ( cliente != null ) {
            id = cliente.getId();
            cpf = cliente.getCpf();
            nome = cliente.getNome();
            documento = cliente.getDocumento();
            email = cliente.getEmail();
        }
        EnderecoResponseDTO endereco = null;
        endereco = enderecoEntityToEnderecoResponseDTO( enderecoEntity );

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO( id, cpf, nome, email, documento, endereco );

        return clienteResponseDTO;
    }

    protected EnderecoResponseDTO enderecoEntityToEnderecoResponseDTO(EnderecoEntity enderecoEntity) {
        if ( enderecoEntity == null ) {
            return null;
        }

        String rua = null;
        Long numero = null;
        String bairro = null;
        String complemento = null;
        String cidade = null;
        String cep = null;

        rua = enderecoEntity.getRua();
        numero = enderecoEntity.getNumero();
        bairro = enderecoEntity.getBairro();
        complemento = enderecoEntity.getComplemento();
        cidade = enderecoEntity.getCidade();
        cep = enderecoEntity.getCep();

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO( rua, numero, bairro, complemento, cidade, cep );

        return enderecoResponseDTO;
    }
}
