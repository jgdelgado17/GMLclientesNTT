package com.clientes.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.cliente.model.Cliente;
import com.clientes.cliente.service.ClienteService;
import com.fasterxml.jackson.annotation.JsonInclude;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer idCliente) {
        return clienteService.findById(idCliente)
                .map(ResponseEntity::ok) // Si fue encontrado correctamente retorne OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no fue encontrado retorne error 404
    }

    @GetMapping("/cd/{cd},{td}")
    @JsonInclude()
    public ResponseEntity<Cliente> findByCedula(@PathVariable("cd") Integer clie_cedula,
            @PathVariable("td") String tipoDocumento) {
        // Validando los tipos de documentos correctos
        if ((tipoDocumento.equals("C") || tipoDocumento.equals("P"))) {
            return clienteService.findByCedula(clie_cedula)
                    .map(ResponseEntity::ok) // Si fue encontrado correctamente retorne OK
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Si no fue encontrado retorne error 404
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cds/{cd}")
    @JsonInclude()
    public ResponseEntity<Cliente> findByCedula2(@PathVariable("cd") Integer clie_cedula) {
        return clienteService.findByCedula2(clie_cedula)
                .map(ResponseEntity::ok) // Si fue encontrado correctamente retorne OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no fue encontrado retorne error 404
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.createUpdate(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {
        return clienteService.findById(cliente.getClie_id()) // Primero verificamos que el cliente existe
                .map(c -> ResponseEntity.ok(clienteService.createUpdate(cliente))) // Si existe lo recorremos con map y
                                                                                   // lo
                // modificamos, atravez de expresión lambda
                // retornamos el cliente c
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no existeretorna error 404
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer idCliente) {
        return clienteService.findById(idCliente)
                .map(c -> {
                    clienteService.delete(idCliente);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
