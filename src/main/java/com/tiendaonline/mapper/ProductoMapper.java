package com.tiendaonline.mapper;

import com.tiendaonline.dto.ProductoRequestDTO;
import com.tiendaonline.dto.ProductoResponseDTO;
import com.tiendaonline.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequestDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }

    public ProductoResponseDTO toResponse(Producto entity) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setStock(entity.getStock());
        return dto;
    }
}