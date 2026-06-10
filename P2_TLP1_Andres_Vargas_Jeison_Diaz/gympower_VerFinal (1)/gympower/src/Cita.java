/**
 * Clase que representa una cita entre un cliente y un entrenador en GymPower.
 * Las citas se guardan en el archivo citas.csv en formato CSV.
 * @author andre
 */
public class Cita {

    /** Usuario del cliente que agenda la cita */
    private String usuarioCliente;

    /** Usuario del entrenador asignado a la cita */
    private String entrenador;

    /** Fecha de la cita en formato dd/mm/aaaa */
    private String fecha;

    /** Hora de la cita en formato hh:mm */
    private String hora;

    /** Motivo o descripcion de la cita */
    private String motivo;

    /**
     * Constructor vacio para deserializacion.
     */
    public Cita() {}

    /**
     * Constructor completo con todos los datos de la cita.
     * @param usuarioCliente usuario del cliente
     * @param entrenador     usuario del entrenador
     * @param fecha          fecha de la cita (dd/mm/aaaa)
     * @param hora           hora de la cita (hh:mm)
     * @param motivo         descripcion o motivo
     */
    public Cita(String usuarioCliente, String entrenador, String fecha, String hora, String motivo) {
        this.usuarioCliente = usuarioCliente;
        this.entrenador = entrenador;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }

    /**
     * Retorna el usuario del cliente.
     * @return usuario del cliente
     */
    public String getUsuarioCliente() { return usuarioCliente; }

    /**
     * Establece el usuario del cliente.
     * @param usuarioCliente usuario a asignar
     */
    public void setUsuarioCliente(String usuarioCliente) { this.usuarioCliente = usuarioCliente; }

    /**
     * Retorna el usuario del entrenador.
     * @return usuario del entrenador
     */
    public String getEntrenador() { return entrenador; }

    /**
     * Establece el usuario del entrenador.
     * @param entrenador usuario del entrenador
     */
    public void setEntrenador(String entrenador) { this.entrenador = entrenador; }

    /**
     * Retorna la fecha de la cita.
     * @return fecha en formato dd/mm/aaaa
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha de la cita.
     * @param fecha nueva fecha
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Retorna la hora de la cita.
     * @return hora en formato hh:mm
     */
    public String getHora() { return hora; }

    /**
     * Establece la hora de la cita.
     * @param hora nueva hora
     */
    public void setHora(String hora) { this.hora = hora; }

    /**
     * Retorna el motivo de la cita.
     * @return descripcion o motivo
     */
    public String getMotivo() { return motivo; }

    /**
     * Establece el motivo de la cita.
     * @param motivo nuevo motivo
     */
    public void setMotivo(String motivo) { this.motivo = motivo; }

    /**
     * Convierte la cita a formato CSV para almacenamiento en archivo.
     * El motivo va al final con separador de 5 partes para admitir comas internas.
     * @return linea CSV representando la cita
     */
    public String toCSV() {
        return usuarioCliente + "," + entrenador + "," + fecha + "," + hora + "," + motivo;
    }

    /**
     * Crea un objeto Cita a partir de una linea CSV leida del archivo.
     * Usa split con limite 5 para preservar comas en el motivo.
     * @param line linea CSV con los datos de la cita
     * @return objeto Cita o null si el formato es invalido
     */
    public static Cita fromCSV(String line) {
        String[] p = line.split(",", 5);
        if (p.length < 5) return null;
        return new Cita(p[0], p[1], p[2], p[3], p[4]);
    }
}
