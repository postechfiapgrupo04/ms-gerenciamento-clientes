package com.fiap.cliente.api.response;

public record ClienteResponseDTO(String id,

                                 String cpf,

                                 String nome,

                                 String email,

                                 String documento,

                                 EnderecoResponseDTO endereco) {


}
