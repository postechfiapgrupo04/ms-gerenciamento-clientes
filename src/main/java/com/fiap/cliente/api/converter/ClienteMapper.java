package com.fiap.cliente.api.converter;


import com.fiap.cliente.api.response.ClienteResponseDTO;
import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import com.fiap.cliente.infrastructure.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", source = "cliente.id")
    @Mapping(target = "cpf", source = "cliente.cpf")
    @Mapping(target = "nome", source = "cliente.nome")
    @Mapping(target = "documento", source = "cliente.documento")
    @Mapping(target = "endereco", source = "enderecoEntity")
    ClienteResponseDTO paraClienteResponseDTO(ClienteEntity cliente, EnderecoEntity enderecoEntity);

}
