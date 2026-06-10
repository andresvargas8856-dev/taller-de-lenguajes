import java.io.*;
import java.util.*;

/**
 * Clase utilitaria para la gestion de datos persistentes en GymPower.
 * Maneja la lectura y escritura de clientes, entrenadores, membresias y citas
 * en archivos CSV. Actua como capa de acceso a datos del sistema.
 * @author Larrynitis
 */
public class DataManager {

    /** Carpeta base donde se guardan los CSV (misma carpeta que el JAR o raiz del proyecto) */
    private static final String BASE_DIR = obtenerDirectorioBase();

    /** Nombre del archivo CSV de clientes */
    private static final String CLIENTES_FILE    = BASE_DIR + "clientes.csv";

    /** Nombre del archivo CSV de entrenadores */
    private static final String ENTRENADORES_FILE = BASE_DIR + "entrenadores.csv";

    /** Nombre del archivo CSV de membresias */
    private static final String MEMBRESIAS_FILE  = BASE_DIR + "membresias.csv";

    /** Nombre del archivo CSV de citas */
    private static final String CITAS_FILE       = BASE_DIR + "citas.csv";

    /**
     * Determina el directorio base para los archivos CSV.
     * Usa la carpeta donde se encuentra el JAR en ejecucion.
     * Si se ejecuta desde clases sueltas (IDE), usa la raiz del proyecto
     * subiendo niveles desde el directorio de clases compiladas.
     * Si no puede determinarlo, usa el directorio de trabajo actual (user.dir).
     * @return ruta del directorio con separador al final
     */
    private static String obtenerDirectorioBase() {
        try {
            java.net.URL location = DataManager.class.getProtectionDomain()
                    .getCodeSource().getLocation();
            java.io.File jarFile = new java.io.File(location.toURI());
            if (jarFile.isFile()) {
                // Ejecutando desde JAR: los CSV van junto al JAR
                return jarFile.getParentFile().getAbsolutePath() + java.io.File.separator;
            } else {
                // Ejecutando desde IDE (clases sueltas): subir hasta la raiz del proyecto
                // NetBeans compila a build/classes, subir dos niveles llega a la raiz
                java.io.File dir = jarFile; // carpeta de clases
                for (int i = 0; i < 2; i++) {
                    if (dir.getParentFile() != null) dir = dir.getParentFile();
                }
                return dir.getAbsolutePath() + java.io.File.separator;
            }
        } catch (Exception e) {
            // Fallback: directorio de trabajo del proceso (raiz del proyecto en NetBeans)
            return System.getProperty("user.dir") + java.io.File.separator;
        }
    }

    // ──────────── CLIENTES ────────────

    /**
     * Carga todos los clientes registrados desde el archivo CSV.
     * Si el archivo no existe o hay error de lectura, retorna lista vacia.
     * @return lista de objetos Cliente
     */
    public static List<Cliente> cargarClientes() {
        List<Cliente> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CLIENTES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Cliente c = Cliente.fromCSV(line);
                if (c != null) lista.add(c);
            }
        } catch (IOException ignored) {}
        return lista;
    }

    /**
     * Guarda un nuevo cliente al final del archivo CSV (modo append).
     * @param cliente objeto Cliente a persistir
     */
    public static void guardarCliente(Cliente cliente) {
        try (FileWriter fw = new FileWriter(CLIENTES_FILE, true);
            PrintWriter pw = new PrintWriter(fw)) {
            pw.println(cliente.toCSV());
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Busca un cliente por usuario y contrasena para autenticacion.
     * @param usuario    nombre de usuario a buscar
     * @param contrasena contrasena a verificar
     * @return el Cliente si las credenciales coinciden, o null si no existe
     */
    public static Cliente buscarCliente(String usuario, String contrasena) {
        for (Cliente c : cargarClientes()) {
            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contrasena))
                return c;
        }
        return null;
    }

    /**
     * Verifica si un nombre de usuario ya existe en el sistema.
     * Usado para evitar usuarios duplicados al registrarse.
     * @param usuario nombre de usuario a verificar
     * @return true si el usuario ya existe, false si esta disponible
     */
    public static boolean usuarioExiste(String usuario) {
        for (Cliente c : cargarClientes()) {
            if (c.getUsuario().equals(usuario)) return true;
        }
        return false;
    }

    // ──────────── ENTRENADORES ────────────

    /**
     * Carga todos los entrenadores desde el archivo CSV.
     * Si el archivo no existe, crea entrenadores predeterminados y los guarda.
     * @return lista de objetos Entrenador
     */
    public static List<Entrenador> cargarEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();
        File f = new File(ENTRENADORES_FILE);
        if (!f.exists()) {
            // Entrenadores predeterminados del gimnasio
            lista.add(new Entrenador("Carlos Perez",  "Musculacion",        "carlos", "1234"));
            lista.add(new Entrenador("Laura Gomez",   "Cardio y HIIT",      "laura",  "1234"));
            lista.add(new Entrenador("Miguel Torres", "Yoga y Flexibilidad", "miguel", "1234"));
            lista.add(new Entrenador("Ana Ramirez",   "Nutricion Deportiva", "ana",    "1234"));
            for (Entrenador e : lista) guardarEntrenador(e);
            return lista;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ENTRENADORES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Entrenador e = Entrenador.fromCSV(line);
                if (e != null) lista.add(e);
            }
        } catch (IOException ignored) {}
        return lista;
    }

    /**
     * Persiste un entrenador en el archivo CSV en modo append.
     * @param entrenador objeto Entrenador a guardar
     */
    public static void guardarEntrenador(Entrenador entrenador) {
        try (FileWriter fw = new FileWriter(ENTRENADORES_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(entrenador.toCSV());
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Busca un entrenador por credenciales para autenticacion.
     * @param usuario    nombre de usuario del entrenador
     * @param contrasena contrasena a verificar
     * @return objeto Entrenador si las credenciales son correctas, o null
     */
    public static Entrenador buscarEntrenador(String usuario, String contrasena) {
        for (Entrenador e : cargarEntrenadores()) {
            if (e.getUsuario().equals(usuario) && e.getContrasena().equals(contrasena))
                return e;
        }
        return null;
    }

    // ──────────── MEMBRESIAS ────────────

    /**
     * Carga todas las membresias guardadas en el archivo CSV.
     * @return lista de objetos Membresia
     */
    public static List<Membresia> cargarMembresias() {
        List<Membresia> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MEMBRESIAS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Membresia m = Membresia.fromCSV(line);
                if (m != null) lista.add(m);
            }
        } catch (IOException ignored) {}
        return lista;
    }

    /**
     * Guarda una membresia nueva en el archivo CSV en modo append.
     * @param membresia objeto Membresia a persistir
     */
    public static void guardarMembresia(Membresia membresia) {
        try (FileWriter fw = new FileWriter(MEMBRESIAS_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(membresia.toCSV());
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Obtiene la membresia mas reciente de un cliente.
     * Recorre la lista al reves para obtener el ultimo registro del usuario.
     * @param usuario nombre de usuario del cliente
     * @return la Membresia mas reciente o null si no tiene ninguna
     */
    public static Membresia obtenerMembresiaCliente(String usuario) {
        List<Membresia> lista = cargarMembresias();
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i).getUsuarioCliente().equals(usuario)) return lista.get(i);
        }
        return null;
    }

    // ──────────── CITAS ────────────

    /**
     * Carga todas las citas almacenadas en el archivo CSV.
     * @return lista de objetos Cita
     */
    public static List<Cita> cargarCitas() {
        List<Cita> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CITAS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Cita c = Cita.fromCSV(line);
                if (c != null) lista.add(c);
            }
        } catch (IOException ignored) {}
        return lista;
    }

    /**
     * Persiste una cita nueva en el archivo CSV en modo append.
     * @param cita objeto Cita a guardar
     */
    public static void guardarCita(Cita cita) {
        try (FileWriter fw = new FileWriter(CITAS_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(cita.toCSV());
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Retorna todas las citas asociadas a un cliente especifico.
     * @param usuario nombre de usuario del cliente
     * @return lista de citas del cliente
     */
    public static List<Cita> citasPorCliente(String usuario) {
        List<Cita> res = new ArrayList<>();
        for (Cita c : cargarCitas()) {
            if (c.getUsuarioCliente().equals(usuario)) res.add(c);
        }
        return res;
    }

    /**
     * Retorna todas las citas asignadas a un entrenador especifico.
     * @param usuario nombre de usuario del entrenador
     * @return lista de citas del entrenador
     */
    public static List<Cita> citasPorEntrenador(String usuario) {
        List<Cita> res = new ArrayList<>();
        for (Cita c : cargarCitas()) {
            if (c.getEntrenador().equals(usuario)) res.add(c);
        }
        return res;
    }
}
