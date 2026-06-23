package com.tiendaonline.controller;

import com.tiendaonline.dto.ProductoRequestDTO;
import com.tiendaonline.dto.ProductoResponseDTO;
import com.tiendaonline.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired private ProductoService service;

    @PostMapping
    public ProductoResponseDTO crear(@RequestBody ProductoRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}