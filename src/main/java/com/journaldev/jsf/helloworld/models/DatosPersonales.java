package com.journaldev.jsf.helloworld.models;

import com.journaldev.jsf.helloworld.enumerations.EstadoCivil;
import com.journaldev.jsf.helloworld.enumerations.Genero;

import java.io.Serializable;
import java.util.Date;

public class DatosPersonales implements Serializable {

    public DatosPersonales(){
        super();
    }
    private Long id;

    private String identificacion;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private Date fechaNace;

    private Date fechaCrea;

    private Date fechaActualiza;

    private EstadoCivil estadoCivil;

    private Genero genero;

    private String ocupacion;

    private Date fechaFallece;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(Date fechaNace) {
        this.fechaNace = fechaNace;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(Date fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }

    public Date getFechaFallece() {
        return fechaFallece;
    }

    public void setFechaFallece(Date fechaFallece) {
        this.fechaFallece = fechaFallece;
    }
}
