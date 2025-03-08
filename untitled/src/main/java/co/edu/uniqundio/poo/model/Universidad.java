package co.edu.uniqundio.poo.model;

import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private String nit;
    private static ArrayList<Estudiante> listaEstudiantes;

    public Universidad(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaEstudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';


    }

    // Crear un estudiante (Crud)
    public String crearEstudiante(String nombre, String appelido, String id) {
        String mensaje = "";
        Estudiante estudianteNuevo = null;
        Estudiante encontrado = null;

        encontrado = buscarEstudiante(id);
        if(encontrado != null){
            mensaje = "Estudiante" + encontrado.getNombre() + " ya existe";
            return  mensaje;
        }
        estudianteNuevo = new Estudiante(nombre, appelido, id);
        listaEstudiantes.add(estudianteNuevo);
        mensaje = "El estudiante se ha registrado correctamente";
        return mensaje;
    }

    //Mostrar Estudiante

    public String mostrarEstudiante(String id){
        String mensaje = "";
        Estudiante estudianteMostrar = null;
        estudianteMostrar = buscarEstudiante(id);
        if(estudianteMostrar != null){
            estudianteMostrar.toString();
            return  estudianteMostrar.toString();
        }else{
            mensaje = "No existe el estudiante solicitado";
        }
        return  mensaje;
    }

    //Eliminar un estudiante (Crud)
    public String eliminarEstudiante(String id) {
        String mensaje = "";
        Estudiante estudianteEliminado = null;

        estudianteEliminado = buscarEstudiante(id);
        if(estudianteEliminado != null){
            listaEstudiantes.remove(estudianteEliminado);
            mensaje = "Estudiante eliminado correctamente";
        }else{
            mensaje = "Estudiante no existe";
        }
        return  mensaje;
    }

    //actualizar los datos (Crud)
    public String actualizarEstudiante(String nombre, String appelido, String id) {
        String mensaje = "";
        Estudiante estudianteActualizar = null;
        estudianteActualizar = buscarEstudiante(id);
        if(estudianteActualizar != null){
            estudianteActualizar.setNombre(nombre);
            estudianteActualizar.setApellido(appelido);
            estudianteActualizar.setId(id);
            mensaje = "Estudiante actualizado correctamente";
        }else{
            mensaje = "Estudiante no existe";
        }
        return mensaje;
    }

    private static Estudiante buscarEstudiante(String id) {
        Estudiante encontrado = null;
        for (Estudiante estudianteAux : listaEstudiantes) {
            if (estudianteAux.getId().equals(id)) {
                return estudianteAux;
            }
        }
        return encontrado;
    }

    public String registrarNota(String id, String nombreNota, float valor){
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiante(id);

        if (estudianteEncontrado != null){
           mensaje = estudianteEncontrado.registrarNota(nombreNota, valor);
        }else{
            mensaje = "Estudiante no existe en la  base de datos";
        }
        return mensaje;
    }

    public String actualizarNota(String id, String nombreNota, float Nuevovalor){
        String mensaje = "";

        Estudiante estudianteEncontrado = buscarEstudiante(id);
        if (estudianteEncontrado != null){
            mensaje = estudianteEncontrado.actualizarNota(nombreNota, Nuevovalor);
        }
        return mensaje;
    }
    public static String eliminarNota(String id, String nombreNota) {
        Estudiante estudianteEncontrado = buscarEstudiante(id);
        if (estudianteEncontrado != null) {
            return estudianteEncontrado.eliminarNota(nombreNota);
        } else {
            return "Estudiante no existe en la base de datos";
        }
    }


    public float calcularPromedioGeneral(){
        float promedio = 0;
        float sumatoria = 0;
        for(Estudiante estudianteAux : listaEstudiantes){
            sumatoria += estudianteAux.calcularDefinitiva();
        }
        promedio = sumatoria / listaEstudiantes.size();
        return promedio;
    }
}
