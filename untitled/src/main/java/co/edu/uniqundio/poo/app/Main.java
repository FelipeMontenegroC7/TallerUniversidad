package co.edu.uniqundio.poo.app;
import co.edu.uniqundio.poo.model.Universidad;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Bienvenido al programa de gestión de la Universidad");
        String nombreUniversidad = JOptionPane.showInputDialog("Ingrese el nombre de universidad");
        String nitUniversidad  = JOptionPane.showInputDialog("Ingrese el nit de la universidad");
        Universidad universidad = new Universidad(nombreUniversidad, nitUniversidad);
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú:\n" +
                    "1. Crear estudiante\n" +
                    "2. Mostrar estudiante\n" +
                    "3. Actualizar estudiante\n" +
                    "4. Eliminar estudiante\n" +
                    "5. Registrar nota\n" +
                    "6. Actualizar nota\n" +
                    "7. Eliminar nota\n" +
                    "8. Calcular promedio general\n" +
                    "9. Salir\n" +
                    "Seleccione una opción:"));

            switch (opcion) {
                case 1: // Crear estudiante
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
                    String id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
                    JOptionPane.showMessageDialog(null, universidad.crearEstudiante(nombre, apellido, id));
                    break;
                case 2: // Mostrar estudiante
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
                    JOptionPane.showMessageDialog(null, universidad.mostrarEstudiante(id));
                    break;
                case 3: // Actualizar estudiante
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante a actualizar:");
                    nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                    apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido:");
                    JOptionPane.showMessageDialog(null, universidad.actualizarEstudiante(nombre, apellido, id));
                    break;
                case 4: // Eliminar estudiante
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante a eliminar:");
                    JOptionPane.showMessageDialog(null, universidad.eliminarEstudiante(id));
                    break;
                case 5: // Registrar nota
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
                    String nombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota:");
                    float valor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la nota:"));
                    JOptionPane.showMessageDialog(null, universidad.registrarNota(id, nombreNota, valor));
                    break;
                case 6: // Actualizar nota
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
                    nombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota a actualizar:");
                    float nuevoValor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo valor de la nota:"));
                    JOptionPane.showMessageDialog(null, universidad.actualizarNota(id, nombreNota, nuevoValor));
                    break;
                case 7: // Eliminar nota
                    id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
                    nombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota a eliminar:");
                    JOptionPane.showMessageDialog(null, Universidad.eliminarNota(id, nombreNota));
                    break;
                case 8: // Calcular promedio general
                    JOptionPane.showMessageDialog(null, "El promedio general es: " + universidad.calcularPromedioGeneral());
                    break;
                case 9: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }
}
