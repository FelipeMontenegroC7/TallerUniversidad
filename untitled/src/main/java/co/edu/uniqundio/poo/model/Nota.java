package co.edu.uniqundio.poo.model;
import com.sun.source.tree.BreakTree;

import java.util.ArrayList;

public class Nota {
    private String nombreNota;
    private Float valor;

    public Nota(String nombreNota, Float valor) {
        this.nombreNota = nombreNota;
        this.valor = valor;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nombre='" + nombreNota + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String actualizarNota(float nuevoValor) {
        setValor(nuevoValor);
        return "Nota actualizada";
    }

}
