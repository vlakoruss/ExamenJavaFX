package org.example.examenjavafx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Usuario {

    private String correo;
    private boolean administrador;
    private String plataforma;
    private Date fecha;

    public Usuario(String correo, boolean administrador, String plataforma) {
        this.correo = correo;
        this.administrador = administrador;
        this.plataforma = plataforma;
        this.fecha = new Date();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return administrador == usuario.administrador && Objects.equals(correo, usuario.correo) && Objects.equals(plataforma, usuario.plataforma);
    }

}
