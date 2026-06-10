import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/// Ventana para que el cliente seleccione su plan de membresia, entrenador y servicios adicionales.
public class ListaMembresia extends JFrame {

    // Atributos para manejar la informacion del cliente y los componentes de la interfaz
    private Cliente cliente;
    private JComboBox<String> cmbPlan;
    private JComboBox<String> cmbEntrenador;
    private JCheckBox chkNutricion, chkClasesGrupales, chkRutina;
    private JLabel lblTotal;

    // Precios base de cada plan para calcular el total
    private final double[] PRECIOS_BASE = {80000, 150000, 250000};
    private final String[] PLANES = {"Basico - $80,000/mes", "Estandar - $150,000/mes", "Premium - $250,000/mes"};

    // Constructor que recibe el cliente para personalizar la experiencia
    public ListaMembresia(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Planes de Membresia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        initUI();
        setVisible(true);
    }

    // Metodo para inicializar la interfaz de usuario con los componentes necesarios
    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 16));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));

        java.awt.Font labelFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);
        java.awt.Font fieldFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 15);
        java.awt.Font btnFont   = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);

        JLabel lPlan = new JLabel("Plan:"); lPlan.setFont(labelFont); panel.add(lPlan);
        cmbPlan = new JComboBox<>(PLANES); cmbPlan.setFont(fieldFont);
        panel.add(cmbPlan);

        JLabel lEnt = new JLabel("Entrenador:"); lEnt.setFont(labelFont); panel.add(lEnt);
        List<Entrenador> entrenadores = DataManager.cargarEntrenadores();
        String[] nombres = new String[entrenadores.size() + 1];
        nombres[0] = "Sin entrenador";
        for (int i = 0; i < entrenadores.size(); i++) nombres[i + 1] = entrenadores.get(i).toString();
        cmbEntrenador = new JComboBox<>(nombres); cmbEntrenador.setFont(fieldFont);
        panel.add(cmbEntrenador);

        JLabel lServ = new JLabel("Servicios adicionales:"); lServ.setFont(labelFont); panel.add(lServ);
        panel.add(new JLabel(""));

        chkNutricion = new JCheckBox("Asesoria nutricional (+$50,000)"); chkNutricion.setFont(fieldFont);
        panel.add(chkNutricion);
        panel.add(new JLabel(""));

        chkClasesGrupales = new JCheckBox("Clases grupales (+$30,000)"); chkClasesGrupales.setFont(fieldFont);
        panel.add(chkClasesGrupales);
        panel.add(new JLabel(""));

        chkRutina = new JCheckBox("Rutina personalizada (+$40,000)"); chkRutina.setFont(fieldFont);
        panel.add(chkRutina);
        panel.add(new JLabel(""));

        JLabel lTotal = new JLabel("Total mensual:"); lTotal.setFont(labelFont); panel.add(lTotal);
        lblTotal = new JLabel("$80,000");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTotal);

        JButton btnConfirmar = new JButton("Confirmar membresia"); btnConfirmar.setFont(btnFont);
        panel.add(btnConfirmar);
        JButton btnVolver = new JButton("Volver"); btnVolver.setFont(btnFont);
        panel.add(btnVolver);

        ActionListener actualizar = e -> actualizarTotal();
        cmbPlan.addActionListener(actualizar);
        chkNutricion.addActionListener(actualizar);
        chkClasesGrupales.addActionListener(actualizar);
        chkRutina.addActionListener(actualizar);

        btnConfirmar.addActionListener(e -> confirmar());
        btnVolver.addActionListener(e -> { new MenuCliente(cliente); dispose(); });

        add(panel);
    }

    // Metodo para actualizar el total a pagar segun las opciones seleccionadas
    private void actualizarTotal() {
        int idx = cmbPlan.getSelectedIndex();
        double total = PRECIOS_BASE[idx];
        if (chkNutricion.isSelected()) total += 50000;
        if (chkClasesGrupales.isSelected()) total += 30000;
        if (chkRutina.isSelected()) total += 40000;
        lblTotal.setText(String.format("$%,.0f", total));
    }

    // Metodo para confirmar la seleccion del cliente, guardar la membresia y mostrar la factura
    private void confirmar() {
        int idx = cmbPlan.getSelectedIndex();
        String[] nombresPlanes = {"Basico", "Estandar", "Premium"};
        Membresia m = new Membresia(nombresPlanes[idx], PRECIOS_BASE[idx], cliente.getUsuario());
        m.setNutricion(chkNutricion.isSelected());
        m.setClasesGrupales(chkClasesGrupales.isSelected());
        m.setRutinaPersonalizada(chkRutina.isSelected());

        // Asignar entrenador si se selecciono uno
        String entSeleccionado = (String) cmbEntrenador.getSelectedItem();
        // Si el cliente no eligio "Sin entrenador", asignamos el entrenador seleccionado
        if (!"Sin entrenador".equals(entSeleccionado)) {
            m.setEntrenadorAsignado(entSeleccionado.split(" - ")[0]);
        } else {
            m.setEntrenadorAsignado("N/A");
        }

        // Guardar la membresia en el sistema y mostrar la factura
        DataManager.guardarMembresia(m);
        new Factura(cliente, m);
        dispose();
    }
}
