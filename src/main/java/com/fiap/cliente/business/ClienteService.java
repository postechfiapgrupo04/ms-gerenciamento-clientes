package com.fiap.cliente.business;

import com.fiap.cliente.api.converter.ClienteConverter;
import com.fiap.cliente.api.converter.ClienteMapper;
import com.fiap.cliente.api.request.ClienteRequestDTO;
import com.fiap.cliente.api.response.ClienteResponseDTO;
import com.fiap.cliente.infrastructure.entity.EnderecoEntity;
import com.fiap.cliente.infrastructure.entity.ClienteEntity;
import com.fiap.cliente.infrastructure.exceptions.BusinessException;
import com.fiap.cliente.infrastructure.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConverter clienteConverter;
    private final ClienteMapper clienteMapper;
    private final EnderecoService enderecoService;


    public ClienteEntity salvaCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    public ClienteResponseDTO gravarCliente(ClienteRequestDTO clienteRequestDTO) {
        try {
            notNull(clienteRequestDTO, "Os dados do Cliente são obrigatórios");
            ClienteEntity clienteEntity = salvaCliente(clienteConverter.paraClienteEntity(clienteRequestDTO));
            EnderecoEntity enderecoEntity = enderecoService.salvaEndereco(
                    clienteConverter.paraEnderecoEntity(clienteRequestDTO.getEndereco(), clienteEntity.getId()));
            return clienteMapper.paraClienteResponseDTO(clienteEntity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de Cliente", e);
        }
    }


    public ClienteResponseDTO buscaDadosCliente(String email) {
        try {
            ClienteEntity entity = clienteRepository.findByEmail(email);
            notNull(entity, "Cliente não encontrado");
            EnderecoEntity enderecoEntity = enderecoService.findByClienteId(entity.getId());

            return clienteMapper.paraClienteResponseDTO(entity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de Cliente", e);
        }
    }

    @Transactional
    public void deletaDadosCliente(String email) {
        ClienteEntity entity = clienteRepository.findByEmail(email);
        clienteRepository.deleteByEmail(email);
        enderecoService.deleteByClienteId(entity.getId());

    }


}
