import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Ventana que muestra la factura detallada de la membresia adquirida por el cliente.
// Incluye fecha, numero de factura, datos del cliente, desglose de costos
// y botones para volver al menu o agendar una cita.
public class Factura extends JFrame {

    // Atributos para almacenar el cliente y la membresia asociada a esta factura
    private Cliente cliente;
    private Membresia membresia;

    // Constructor que recibe el cliente y la membresia, configura la ventana
    // y llama al metodo para inicializar la interfaz
    public Factura(Cliente cliente, Membresia membresia) {
        this.cliente = cliente;
        this.membresia = membresia;
        setTitle("Factura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        initUI();
        setVisible(true);
    }

    // Metodo para crear y organizar los componentes de la interfaz.
    // Usa GridLayout para una presentacion ordenada.
    // Formatea la fecha y el total a mostrar en la factura.
    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(14, 2, 6, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 180, 40, 180));

        java.awt.Font labelFont = new Font("Arial", Font.PLAIN, 16);
        java.awt.Font valueFont = new Font("Arial", Font.PLAIN, 16);

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        JLabel titulo = new JLabel("FACTURA - GymPower");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titulo);
        panel.add(new JLabel(""));

        JLabel lFecha = new JLabel("Fecha:"); lFecha.setFont(labelFont); panel.add(lFecha);
        JLabel vFecha = new JLabel(fecha); vFecha.setFont(valueFont); panel.add(vFecha);

        JLabel lFactura = new JLabel("N Factura:"); lFactura.setFont(labelFont); panel.add(lFactura);
        JLabel vFactura = new JLabel("FL-" + System.currentTimeMillis() % 100000); vFactura.setFont(valueFont); panel.add(vFactura);

        JSeparator sep1 = new JSeparator();
        panel.add(sep1);
        panel.add(new JLabel(""));

        JLabel lNombre = new JLabel("Nombre:"); lNombre.setFont(labelFont); panel.add(lNombre);
        JLabel vNombre = new JLabel(cliente.getNombre() + " " + cliente.getApellido()); vNombre.setFont(valueFont); panel.add(vNombre);

        JLabel lUsuario = new JLabel("Usuario:"); lUsuario.setFont(labelFont); panel.add(lUsuario);
        JLabel vUsuario = new JLabel(cliente.getUsuario()); vUsuario.setFont(valueFont); panel.add(vUsuario);

        JLabel lCorreo = new JLabel("Correo:"); lCorreo.setFont(labelFont); panel.add(lCorreo);
        JLabel vCorreo = new JLabel(cliente.getCorreo()); vCorreo.setFont(valueFont); panel.add(vCorreo);

        JSeparator sep2 = new JSeparator();
        panel.add(sep2);
        panel.add(new JLabel(""));

        JLabel lPlan = new JLabel("Plan " + membresia.getPlan() + ":"); lPlan.setFont(labelFont); panel.add(lPlan);
        JLabel vPlan = new JLabel(String.format("$%,.0f", membresia.getPrecioBase())); vPlan.setFont(valueFont); panel.add(vPlan);

        // Agrega los servicios adicionales seleccionados y sus costos
        if (membresia.isNutricion()) {
            JLabel l = new JLabel("Asesoria nutricional:"); l.setFont(labelFont); panel.add(l);
            JLabel v = new JLabel("$50,000"); v.setFont(valueFont); panel.add(v);
        }
        if (membresia.isClasesGrupales()) {
            JLabel l = new JLabel("Clases grupales:"); l.setFont(labelFont); panel.add(l);
            JLabel v = new JLabel("$30,000"); v.setFont(valueFont); panel.add(v);
        }
        if (membresia.isRutinaPersonalizada()) {
            JLabel l = new JLabel("Rutina personalizada:"); l.setFont(labelFont); panel.add(l);
            JLabel v = new JLabel("$40,000"); v.setFont(valueFont); panel.add(v);
        }

        // Calcula y muestra el total a pagar por la membresia con los servicios adicionales
        JLabel lblTotal = new JLabel("TOTAL:");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lblTotal);

        // Formatea el total con separadores de miles y sin decimales
        JLabel lblValor = new JLabel(String.format("$%,.0f", membresia.calcularTotal()));
        lblValor.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lblValor);

        // Botones para volver al menu o agendar una cita
        JButton btnMenu = new JButton("Ir al menu");
        btnMenu.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(btnMenu);
        JButton btnCita = new JButton("Agendar cita");
        btnCita.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(btnCita);

        // ActionListeners para navegar a las ventanas correspondientes y cerrar la factura
        btnMenu.addActionListener(e -> { new MenuCliente(cliente); dispose(); });
        btnCita.addActionListener(e -> { new ConfirmarCita(cliente); dispose(); });

        add(panel);
    }
}
