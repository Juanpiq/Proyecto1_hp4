package com.example.proyecto1;

public class Estudiante {
    public String cedula;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int voto;
    public Estudiante(String cedula, int voto) {
        this.cedula = cedula;
        this.voto = voto;
    }
}
