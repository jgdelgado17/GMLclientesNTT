package com.clientes.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clie_id;

    @NotNull
    @Column(nullable = false, unique = true)
    private Integer clieCedula;

    @NotNull
    @Column(columnDefinition = "VARCHAR(2) CHECK (clie_tipo_Documento IN ('C', 'P'))")
    private String clie_tipoDocumento;

    @NotNull
    @Column()
    private String clie_primerNombre;

    @NotNull
    @Column()
    private String clie_segundoNombre;

    @NotNull
    @Column()
    private String clie_primerApellido;

    @NotNull
    @Column()
    private String clie_segundopellido;

    @Column()
    private String clie_telefono;

    @Column()
    private String clie_direccion;

    @Column()
    private String clie_ciudadResidencia;

    public Cliente() {
    }

    public Cliente(@NotNull String clie_tipoDocumento, @NotNull String clie_primerNombre,
            @NotNull String clie_segundoNombre, @NotNull String clie_primerApellido,
            @NotNull String clie_segundopellido, String clie_telefono, String clie_direccion,
            String clie_ciudadResidencia) {
        this.clie_tipoDocumento = clie_tipoDocumento;
        this.clie_primerNombre = clie_primerNombre;
        this.clie_segundoNombre = clie_segundoNombre;
        this.clie_primerApellido = clie_primerApellido;
        this.clie_segundopellido = clie_segundopellido;
        this.clie_telefono = clie_telefono;
        this.clie_direccion = clie_direccion;
        this.clie_ciudadResidencia = clie_ciudadResidencia;
    }

    public Integer getClie_id() {
        return clie_id;
    }

    public void setClie_id(Integer clie_id) {
        this.clie_id = clie_id;
    }

    public Integer getClieCedula() {
        return clieCedula;
    }

    public void setClieCedula(Integer clieCedula) {
        this.clieCedula = clieCedula;
    }

    public String getClie_tipoDocumento() {
        return clie_tipoDocumento;
    }

    public void setClie_tipoDocumento(String clie_tipoDocumento) {
        this.clie_tipoDocumento = clie_tipoDocumento;
    }

    public String getClie_primerNombre() {
        return clie_primerNombre;
    }

    public void setClie_primerNombre(String clie_primerNombre) {
        this.clie_primerNombre = clie_primerNombre;
    }

    public String getClie_segundoNombre() {
        return clie_segundoNombre;
    }

    public void setClie_segundoNombre(String clie_segundoNombre) {
        this.clie_segundoNombre = clie_segundoNombre;
    }

    public String getClie_primerApellido() {
        return clie_primerApellido;
    }

    public void setClie_primerApellido(String clie_primerApellido) {
        this.clie_primerApellido = clie_primerApellido;
    }

    public String getClie_segundopellido() {
        return clie_segundopellido;
    }

    public void setClie_segundopellido(String clie_segundopellido) {
        this.clie_segundopellido = clie_segundopellido;
    }

    public String getClie_telefono() {
        return clie_telefono;
    }

    public void setClie_telefono(String clie_telefono) {
        this.clie_telefono = clie_telefono;
    }

    public String getClie_direccion() {
        return clie_direccion;
    }

    public void setClie_direccion(String clie_direccion) {
        this.clie_direccion = clie_direccion;
    }

    public String getClie_ciudadResidencia() {
        return clie_ciudadResidencia;
    }

    public void setClie_ciudadResidencia(String clie_ciudadResidencia) {
        this.clie_ciudadResidencia = clie_ciudadResidencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clieCedula == null) ? 0 : clieCedula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (clieCedula == null) {
            if (other.clieCedula != null)
                return false;
        } else if (!clieCedula.equals(other.clieCedula))
            return false;
        return true;
    }

}
