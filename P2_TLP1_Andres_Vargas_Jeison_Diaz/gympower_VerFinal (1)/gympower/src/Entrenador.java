/**
 * Clase que representa un entrenador del gimnasio GymPower.
 * Contiene los datos personales, especialidad y credenciales de acceso.
 * Se persiste en el archivo entrenadores.csv en formato CSV.
 * @author andre
 */
public class Entrenador {

    /** Nombre completo del entrenador */
    private String nombre;

    /** Especialidad o disciplina del entrenador */
    private String especialidad;

    /** Nombre de usuario para inicio de sesion */
    private String usuario;

    /** Contrasena de acceso al sistema */
    private String contrasena;

    /**
     * Constructor vacio necesario para deserializacion.
     */
    public Entrenador() {}

    /**
     * Constructor completo con todos los datos del entrenador.
     * @param nombre       nombre del entrenador
     * @param especialidad area de especializacion
     * @param usuario      nombre de usuario unico
     * @param contrasena   contrasena de acceso
     */
    public Entrenador(String nombre, String especialidad, String usuario, String contrasena) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Retorna el nombre del entrenador.
     * @return nombre completo
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del entrenador.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna la especialidad del entrenador.
     * @return especialidad o disciplina
     */
    public String getEspecialidad() { return especialidad; }

    /**
     * Establece la especialidad del entrenador.
     * @param especialidad nueva especialidad
     */
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    /**
     * Retorna el nombre de usuario del entrenador.
     * @return usuario de login
     */
    public String getUsuario() { return usuario; }

    /**
     * Establece el nombre de usuario del entrenador.
     * @param usuario nuevo usuario
     */
    public void setUsuario(String usuario) { this.usuario = usuario; }

    /**
     * Retorna la contrasena del entrenador.
     * @return contrasena
     */
    public String getContrasena() { return contrasena; }

    /**
     * Establece la contrasena del entrenador.
     * @param contrasena nueva contrasena
     */
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    /**
     * Serializa el entrenador a formato CSV para escritura en archivo.
     * Formato: nombre,especialidad,usuario,contrasena
     * @return linea en formato CSV
     */
    public String toCSV() {
        return nombre + "," + especialidad + "," + usuario + "," + contrasena;
    }

    /**
     * Deserializa una linea CSV y crea un objeto Entrenador.
     * Retorna null si la linea no cumple el formato esperado.
     * @param line linea CSV del archivo de entrenadores
     * @return objeto Entrenador o null si el formato es invalido
     */
    public static Entrenador fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) return null;
        return new Entrenador(parts[0], parts[1], parts[2], parts[3]);
    }

    /**
     * Representacion en texto del entrenador para mostrar en JComboBox.
     * Formato: "Nombre - Especialidad"
     * @return cadena de texto con nombre y especialidad
     */
    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}
