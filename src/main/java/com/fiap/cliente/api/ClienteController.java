package com.fiap.cliente.api;


import com.fiap.cliente.api.request.ClienteRequestDTO;
import com.fiap.cliente.api.response.ClienteResponseDTO;
import com.fiap.cliente.business.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<ClienteResponseDTO> gravaDadosCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(clienteService.gravarCliente(clienteRequestDTO));
    }


    @GetMapping()
    public ResponseEntity<ClienteResponseDTO> buscaClientePorEmail(@RequestParam ("email") String email) {
        return ResponseEntity.ok(clienteService.buscaDadosCliente(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaDadosCliente(@RequestParam ("email") String email) {
        clienteService.deletaDadosCliente(email);
        return ResponseEntity.accepted().build();
    }


}
