package com.tiendaonline.service;

import com.tiendaonline.dto.ClienteRequestDTO;
import com.tiendaonline.dto.ClienteResponseDTO;
import com.tiendaonline.mapper.ClienteMapper;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired private ClienteRepository repository;
    @Autowired private ClienteMapper mapper;

    public ClienteResponseDTO crear(ClienteRequestDTO dto) {
        Cliente cliente = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(cliente));
    }

    public List<ClienteResponseDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscar(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow();
        return mapper.toResponse(cliente);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("El cliente no existe");
        }
        repository.deleteById(id);
    }
}