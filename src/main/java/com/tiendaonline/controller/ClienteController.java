package com.tiendaonline.controller;

import com.tiendaonline.dto.ClienteRequestDTO;
import com.tiendaonline.dto.ClienteResponseDTO;
import com.tiendaonline.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired private ClienteService service;

    @PostMapping
    public ClienteResponseDTO crear(@RequestBody ClienteRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}