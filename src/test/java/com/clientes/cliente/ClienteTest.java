package com.clientes.cliente;

public class ClienteTest {
    private int clie_id;
    private int clieCedula;
    private String clie_tipoDocumento;
    private String clie_primerNombre;
    private String clie_segundoNombre;
    private String clie_primerApellido;
    private String clie_segundopellido;
    private String clie_telefono;
    private String clie_direccion;
    private String clie_ciudadResidencia;

    public ClienteTest(int clie_id, int clieCedula, String clie_tipoDocumento, String clie_primerNombre,
            String clie_segundoNombre, String clie_primerApellido, String clie_segundopellido, String clie_telefono,
            String clie_direccion, String clie_ciudadResidencia) {
        this.clie_id = clie_id;
        this.clieCedula = clieCedula;
        this.clie_tipoDocumento = clie_tipoDocumento;
        this.clie_primerNombre = clie_primerNombre;
        this.clie_segundoNombre = clie_segundoNombre;
        this.clie_primerApellido = clie_primerApellido;
        this.clie_segundopellido = clie_segundopellido;
        this.clie_telefono = clie_telefono;
        this.clie_direccion = clie_direccion;
        this.clie_ciudadResidencia = clie_ciudadResidencia;
    }

    public int getClieCedula() {
        return clieCedula;
    }

    public void setClieCedula(int clieCedula) {
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

    public int getClie_id() {
        return clie_id;
    }

    public void setClie_id(int clie_id) {
        this.clie_id = clie_id;
    }

}
