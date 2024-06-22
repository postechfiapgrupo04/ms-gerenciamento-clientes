package com.fiap.cliente.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ClienteRequestDTO {

    private String cpf;

    private String nome;

    @JsonProperty(required = true)
    private String email;

    private String documento;

    private EnderecoRequestDTO endereco;


}
