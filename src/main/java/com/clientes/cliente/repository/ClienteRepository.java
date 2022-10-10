package com.clientes.cliente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public Optional<Cliente> findByClieCedula(Integer clie_cedula);
}
