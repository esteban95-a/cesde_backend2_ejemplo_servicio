package com.example.demo_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.repository.ProveedorRepository;

@Service


public class ProveedorService {
private final ProveedorRepository proveedorRepository;

public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;

}
    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getTelefono() == null || proveedor.getTelefono().length() != 10) {
            throw new RuntimeException("El número de teléfono debe tener exactamente 10 dígitos");
        }
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    public List<Proveedor> buscarPorNombre(String nombre) {
        return proveedorRepository.findByNombreContainingIgnoreCase(nombre);
    }

}
