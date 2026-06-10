/**
 * Clase que representa una membresia contratada por un cliente en GymPower.
 * Contiene el plan base, servicios adicionales y el entrenador asignado.
 * Se guarda en el archivo membresias.csv en formato CSV.
 * @author andre
 */
public class Membresia {

    /** Tipo de plan: Basico, Estandar o Premium */
    private String plan;

    /** Precio mensual base del plan en pesos colombianos */
    private double precioBase;

    /** Indica si incluye asesoria nutricional (+$50.000) */
    private boolean nutricion;

    /** Indica si incluye clases grupales (+$30.000) */
    private boolean clasesGrupales;

    /** Indica si incluye rutina personalizada (+$40.000) */
    private boolean rutinaPersonalizada;

    /** Nombre del entrenador asignado o "N/A" si no tiene */
    private String entrenadorAsignado;

    /** Usuario del cliente propietario de la membresia */
    private String usuarioCliente;

    /**
     * Constructor vacio necesario para deserializacion CSV.
     */
    public Membresia() {}

    /**
     * Constructor con los campos principales de la membresia.
     * @param plan           nombre del plan (Basico, Estandar, Premium)
     * @param precioBase     precio base mensual
     * @param usuarioCliente usuario del cliente que contrata
     */
    public Membresia(String plan, double precioBase, String usuarioCliente) {
        this.plan = plan;
        this.precioBase = precioBase;
        this.usuarioCliente = usuarioCliente;
    }

    /**
     * Calcula el costo total de la membresia sumando servicios adicionales.
     * @return total mensual en pesos colombianos
     */
    public double calcularTotal() {
        double total = precioBase;
        if (nutricion)         total += 50000;
        if (clasesGrupales)    total += 30000;
        if (rutinaPersonalizada) total += 40000;
        return total;
    }

    /**
     * Retorna el nombre del plan.
     * @return plan de membresia
     */
    public String getPlan() { return plan; }

    /**
     * Establece el nombre del plan.
     * @param plan nuevo plan
     */
    public void setPlan(String plan) { this.plan = plan; }

    /**
     * Retorna el precio base mensual.
     * @return precio base
     */
    public double getPrecioBase() { return precioBase; }

    /**
     * Establece el precio base mensual.
     * @param precioBase nuevo precio
     */
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    /**
     * Indica si tiene asesoria nutricional.
     * @return true si incluye nutricion
     */
    public boolean isNutricion() { return nutricion; }

    /**
     * Activa o desactiva la asesoria nutricional.
     * @param nutricion true para incluir
     */
    public void setNutricion(boolean nutricion) { this.nutricion = nutricion; }

    /**
     * Indica si incluye clases grupales.
     * @return true si incluye clases grupales
     */
    public boolean isClasesGrupales() { return clasesGrupales; }

    /**
     * Activa o desactiva las clases grupales.
     * @param clasesGrupales true para incluir
     */
    public void setClasesGrupales(boolean clasesGrupales) { this.clasesGrupales = clasesGrupales; }

    /**
     * Indica si incluye rutina personalizada.
     * @return true si incluye rutina
     */
    public boolean isRutinaPersonalizada() { return rutinaPersonalizada; }

    /**
     * Activa o desactiva la rutina personalizada.
     * @param rutinaPersonalizada true para incluir
     */
    public void setRutinaPersonalizada(boolean rutinaPersonalizada) { this.rutinaPersonalizada = rutinaPersonalizada; }

    /**
     * Retorna el nombre del entrenador asignado.
     * @return nombre del entrenador o "N/A"
     */
    public String getEntrenadorAsignado() { return entrenadorAsignado; }

    /**
     * Asigna un entrenador a la membresia.
     * @param entrenadorAsignado nombre del entrenador
     */
    public void setEntrenadorAsignado(String entrenadorAsignado) { this.entrenadorAsignado = entrenadorAsignado; }

    /**
     * Retorna el usuario del cliente dueno de la membresia.
     * @return usuario del cliente
     */
    public String getUsuarioCliente() { return usuarioCliente; }

    /**
     * Establece el usuario del cliente.
     * @param usuarioCliente nuevo usuario
     */
    public void setUsuarioCliente(String usuarioCliente) { this.usuarioCliente = usuarioCliente; }

    /**
     * Serializa la membresia a formato CSV para almacenamiento.
     * Formato: usuario,plan,precioBase,nutricion,clasesGrupales,rutinaPersonalizada,entrenador
     * @return linea CSV con los datos de la membresia
     */
    public String toCSV() {
        return usuarioCliente + "," + plan + "," + precioBase + "," +
               nutricion + "," + clasesGrupales + "," + rutinaPersonalizada + "," +
               (entrenadorAsignado != null ? entrenadorAsignado : "N/A");
    }

    /**
     * Crea un objeto Membresia desde una linea CSV del archivo.
     * @param line linea CSV con los datos de la membresia
     * @return objeto Membresia o null si el formato es invalido
     */
    public static Membresia fromCSV(String line) {
        String[] p = line.split(",");
        // Validacion basica de formato
        if (p.length < 7) return null;
        Membresia m = new Membresia(p[1], Double.parseDouble(p[2]), p[0]);
        m.setNutricion(Boolean.parseBoolean(p[3]));
        m.setClasesGrupales(Boolean.parseBoolean(p[4]));
        m.setRutinaPersonalizada(Boolean.parseBoolean(p[5]));
        m.setEntrenadorAsignado(p[6]);
        return m;
    }
}
