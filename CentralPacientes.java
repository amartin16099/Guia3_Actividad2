/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer paciente de la lista
     */
    private Paciente primero;
    /**
     * Número de pacientes en la central
     */
    private int numPacientes;

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        primero = null;
        numPacientes = 0;
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
         if (primero == null) // Crea la cabeza si no existe
        {
            primero = pac;
        }
        else
        // Realiza la adición antes del paciente que está al inicio de la lista
        {
            pac.insertarDespues(primero);
            primero = pac;
        }
        numPacientes++;
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
    if (primero == null) // Si la cabeza no existe adiciona de primero el paciente
        {
            primero = pac;
        }
        else {
            // Busca el último paciente de la lista
            Paciente p = localizarUltimo();

            // Adiciona el paciente después del último paciente de la lista
            p.insertarDespues(pac);
        }
        numPacientes++;
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
    Paciente anterior = localizar(cod);

        if (anterior == null) // Si no existe el paciente después del que se desea realizar la adición se arroja la excepción
        {
            throw new NoExisteException(cod);
        }
        else
        // Se adiciona el paciente
        {
            anterior.insertarDespues(pac);
        }
        numPacientes++;
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el método
     Paciente actual = primero;
        while (actual != null && actual.darCodigo() != codigo) {
            actual = actual.darSiguiente();
        }
        return actual;
    }
    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        Paciente actual = primero;

        while (actual != null) {
            listaPacientes.add(actual);
            actual = actual.darSiguiente();
        }

        return listaPacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */


    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        Paciente actual = primero;
        int longitud = 0;

        while (actual != null) {
            longitud++;
            actual = actual.darSiguiente();
        }
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int cont = 0;
        Paciente p = primero;
        while(p != null) {
            if (p.darSexo() == 1)
                cont += 1;
            p = p.darSiguiente();
        }
        return cont;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int cont = 0;
        Paciente p = primero;
        while(p != null) {
            if (p.darSexo() == 2)
                cont += 1;
            p = p.darSiguiente();
        }
        return cont;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // TODO: Completar
        if (listaClinicas.isEmpty()) {
            return "No hay clínicas registradas";
        }

        String clinicaMasOcupada = listaClinicas.get(0);
        int maxPacientes = 0;

        for (String clinica : listaClinicas) {
            int numPacientesClinica = 0;

            for (Paciente paciente : pacientes) {
                if (paciente.darClinica().equals(clinica)) {
                    numPacientesClinica++;
                }
            }

            if (numPacientesClinica > maxPacientes) {
                maxPacientes = numPacientesClinica;
                clinicaMasOcupada = clinica;
            }
        }

        return clinicaMasOcupada;
    }
    private Paciente localizarUltimo() {
        if (primero == null) {
            return null; // La lista está vacía
        }

        Paciente actual = primero;
        while (actual.darSiguiente() != null) {
            actual = actual.darSiguiente();
        }

        return actual;
    }
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

}