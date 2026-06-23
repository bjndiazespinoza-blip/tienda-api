package com.tiendaonline.mapper;

import com.tiendaonline.dto.ClienteRequestDTO;
import com.tiendaonline.dto.ClienteResponseDTO;
import com.tiendaonline.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    // Convertir de DTO (entrada) a Entidad (base de datos)
    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        return cliente;
    }

    // Convertir de Entidad (base de datos) a DTO (salida al usuario)
    public ClienteResponseDTO toResponse(Cliente entity) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        return dto;
    }
}