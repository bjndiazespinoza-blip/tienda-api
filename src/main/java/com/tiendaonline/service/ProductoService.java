package com.tiendaonline.service;

import com.tiendaonline.dto.ProductoRequestDTO;
import com.tiendaonline.dto.ProductoResponseDTO;
import com.tiendaonline.mapper.ProductoMapper;
import com.tiendaonline.model.Producto;
import com.tiendaonline.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired private ProductoRepository repository;
    @Autowired private ProductoMapper mapper;

    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        Producto p = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(p));
    }

    public List<ProductoResponseDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO buscar(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}