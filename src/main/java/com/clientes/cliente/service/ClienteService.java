package com.clientes.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.cliente.model.Cliente;
import com.clientes.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;

    public Cliente createUpdate(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public void delete(Integer id) {
        clienteRepo.deleteById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepo.findById(id);
    }

    public Optional<Cliente> findByCedula2(Integer clie_cedula) {
        return clienteRepo.findByClieCedula(clie_cedula);
    }

    public Optional<Cliente> findByCedula(Integer clie_cedula) {
        Cliente cliente = clienteRepo.findByClieCedula(clie_cedula).get();
        String tipoDocumento = null;
        String primerNombre = cliente.getClie_primerNombre();
        String segundoNombre = cliente.getClie_segundoNombre();
        String primerApellido = cliente.getClie_primerApellido();
        String telefono = cliente.getClie_telefono();
        String direccion = cliente.getClie_direccion();
        String residencia = cliente.getClie_ciudadResidencia();
        Cliente cliente2 = new Cliente(tipoDocumento, primerNombre, segundoNombre, primerApellido, primerApellido,
                telefono, direccion, residencia);

        Optional<Cliente> clieResponse = Optional.ofNullable(cliente2);

        return clieResponse;
    }
}
