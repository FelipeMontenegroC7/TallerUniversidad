package co.edu.uniqundio.poo.model;


public class Estudiante {
    private String nombre;
    private String apellido;
    private String id;
    private Nota[] listaNotas;

    public Estudiante(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.listaNotas = new Nota[5];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Nota[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String registrarNota(String nombreNota, float valor) {
        int posDisponible = -1;
        posDisponible = buscarPosicion();

        if (posDisponible == -1){
            return "No hay espacio para más notas";
        }else{
            Nota nota = new Nota(nombreNota, valor);
            listaNotas[posDisponible] = nota;
            return "La nota fue registrada";
        }
    }

    private int buscarPosicion(){
        for(int i = 0; i < listaNotas.length; i++){
            if(listaNotas [i] == null){
                return i;
            }
        }
        return -1;
    }

    public float calcularDefinitiva(){
        int sumatoria = 0;
        float definitiva = 0;

        for(Nota notaAux : listaNotas){
            if(notaAux != null){
                sumatoria += notaAux.getValor();
            }
        }
        definitiva = sumatoria / 5;
        return definitiva;
    }

    public String actualizarNota(String nombreNota, float nuevoValor) {
        String mensaje = "";

        Nota notaEncontrada = buscarNota(nombreNota);
        if(notaEncontrada != null){
            mensaje = notaEncontrada.actualizarNota(nuevoValor);
        }else{
            mensaje = "No existe la nota";
        }
        return mensaje;
    }

    private Nota buscarNota(String nombreNota){
        Nota notaEncontrada = null;
        for(Nota notaAux : listaNotas){
        if(notaAux != null && notaAux.getNombreNota().equals(nombreNota)){
            notaEncontrada = notaAux;
            break;
        }
        }
        return notaEncontrada;
    }

    public String eliminarNota(String nombreNota) {
        String mensaje = "";
        Nota notaEncontrada = buscarNota(nombreNota);

        if (notaEncontrada != null) {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] == notaEncontrada) {
                    listaNotas[i] = null; // Eliminamos la nota
                    mensaje = "Nota eliminada correctamente";
                }else{
                    mensaje = "La nota no se encuentra disponible";
                }
            }
        }
        return mensaje;
    }


}