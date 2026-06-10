/**
 * Clase que representa un cliente del gimnasio GymPower.
 * Almacena los datos personales y de acceso del cliente.
 * Los datos se persisten en formato CSV en el archivo clientes.csv.
 * @author andre
 */
public class Cliente {

    /** Nombre del cliente */
    private String nombre;

    /** Apellido del cliente */
    private String apellido;

    /** Nombre de usuario unico para iniciar sesion */
    private String usuario;

    /** Contrasena de acceso al sistema */
    private String contrasena;

    /** Correo electronico del cliente */
    private String correo;

    /**
     * Constructor vacio requerido para deserializacion.
     */
    public Cliente() {}

    /**
     * Constructor completo con todos los datos del cliente.
     * @param nombre     nombre del cliente
     * @param apellido   apellido del cliente
     * @param usuario    nombre de usuario unico
     * @param contrasena contrasena de acceso
     * @param correo     correo electronico
     */
    public Cliente(String nombre, String apellido, String usuario, String contrasena, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    /**
     * Retorna el nombre del cliente.
     * @return nombre del cliente
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del cliente.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna el apellido del cliente.
     * @return apellido del cliente
     */
    public String getApellido() { return apellido; }

    /**
     * Establece el apellido del cliente.
     * @param apellido nuevo apellido
     */
    public void setApellido(String apellido) { this.apellido = apellido; }

    /**
     * Retorna el nombre de usuario.
     * @return usuario del cliente
     */
    public String getUsuario() { return usuario; }

    /**
     * Establece el nombre de usuario.
     * @param usuario nuevo usuario
     */
    public void setUsuario(String usuario) { this.usuario = usuario; }

    /**
     * Retorna la contrasena del cliente.
     * @return contrasena
     */
    public String getContrasena() { return contrasena; }

    /**
     * Establece la contrasena del cliente.
     * @param contrasena nueva contrasena
     */
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    /**
     * Retorna el correo electronico del cliente.
     * @return correo electronico
     */
    public String getCorreo() { return correo; }

    /**
     * Establece el correo electronico del cliente.
     * @param correo nuevo correo
     */
    public void setCorreo(String correo) { this.correo = correo; }

    /**
     * Serializa el objeto a formato CSV para guardarlo en archivo.
     * El formato es: nombre,apellido,usuario,contrasena,correo
     * @return linea CSV con los datos del cliente
     */
    public String toCSV() {
        return nombre + "," + apellido + "," + usuario + "," + contrasena + "," + correo;
    }

    /**
     * Crea un objeto Cliente a partir de una linea CSV leida del archivo.
     * Retorna null si la linea no tiene el formato correcto.
     * @param line linea CSV con los datos del cliente
     * @return objeto Cliente o null si el formato es invalido
     */
    public static Cliente fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 5) return null;
        return new Cliente(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
