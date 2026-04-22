package com.example.demo_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.service.ProveedorService;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
private final ProveedorService proveedorService;

public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
    @GetMapping
    public ResponseEntity<List<Proveedor>> listar() {
        return ResponseEntity.ok(proveedorService.listar());
    }

    @PostMapping
    public ResponseEntity<Proveedor> crear(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.guardar(proveedor));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Proveedor>> buscar(@RequestParam String nombre) {
        return ResponseEntity.ok(proveedorService.buscarPorNombre(nombre));
    }
}
