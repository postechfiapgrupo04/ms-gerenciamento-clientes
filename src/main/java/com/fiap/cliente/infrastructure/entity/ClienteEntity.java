package com.fiap.cliente.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "cliente_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    private String id;
    private String cpf;
    private String nome;
    private String email;
    private String documento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

}
