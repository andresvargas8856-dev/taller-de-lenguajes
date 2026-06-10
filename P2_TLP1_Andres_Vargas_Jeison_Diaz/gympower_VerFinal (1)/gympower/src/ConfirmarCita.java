import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ConfirmarCita extends JFrame {

    // Atributos
    private Cliente cliente;
    private JComboBox<String> cmbEntrenador;
    private JTextField txtFecha, txtHora, txtMotivo;

    // Constructor
    public ConfirmarCita(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Confirmar Cita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        initUI();
        setVisible(true);
    }

    // Metodos
    private void initUI() {
        java.awt.Font labelFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);
        java.awt.Font fieldFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 15);
        java.awt.Font btnFont   = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);

        // Panel principal con GridLayout para organizar los campos
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 18));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));

        // Mostrar datos del cliente
        JLabel lblCliente = new JLabel("Cliente:"); lblCliente.setFont(labelFont); panel.add(lblCliente);
        JLabel lblNombreCliente = new JLabel(cliente.getNombre() + " " + cliente.getApellido()); lblNombreCliente.setFont(fieldFont); panel.add(lblNombreCliente);

        // Mostrar lista de entrenadores
        JLabel lblEnt = new JLabel("Entrenador:"); lblEnt.setFont(labelFont); panel.add(lblEnt);
        List<Entrenador> entrenadores = DataManager.cargarEntrenadores();
        String[] nombres = new String[entrenadores.size()];
        for (int i = 0; i < entrenadores.size(); i++) nombres[i] = entrenadores.get(i).toString();
        cmbEntrenador = new JComboBox<>(nombres);
        cmbEntrenador.setFont(fieldFont);
        panel.add(cmbEntrenador);

        // Campos para fecha, hora y motivo
        JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):"); lblFecha.setFont(labelFont); panel.add(lblFecha);
        txtFecha = new JTextField(); txtFecha.setFont(fieldFont);
        panel.add(txtFecha);

        // Mostrar campos para hora y motivo
        JLabel lblHora = new JLabel("Hora (hh:mm):"); lblHora.setFont(labelFont); panel.add(lblHora);
        txtHora = new JTextField(); txtHora.setFont(fieldFont);
        panel.add(txtHora);

        // Mostrar campo para motivo
        JLabel lblMotivo = new JLabel("Motivo:"); lblMotivo.setFont(labelFont); panel.add(lblMotivo);
        txtMotivo = new JTextField(); txtMotivo.setFont(fieldFont);
        panel.add(txtMotivo);

        // Botones para agendar y volver
        JButton btnAgendar = new JButton("Agendar cita"); btnAgendar.setFont(btnFont);
        panel.add(btnAgendar);
        JButton btnVolver = new JButton("Volver"); btnVolver.setFont(btnFont);
        panel.add(btnVolver);

        // Agregar listeners a los botones
        btnAgendar.addActionListener(e -> agendarCita());
        btnVolver.addActionListener(e -> { new MenuCliente(cliente); dispose(); });

        add(panel);
    }

    // Metodos
    private void agendarCita() {
        String fecha  = txtFecha.getText().trim();
        String hora   = txtHora.getText().trim();
        String motivo = txtMotivo.getText().trim();

        // Validar que no haya campos vacios
        if (fecha.isEmpty() || hora.isEmpty() || motivo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el usuario del entrenador seleccionado
        String entrenadorStr = (String) cmbEntrenador.getSelectedItem();
        String nombreEnt = entrenadorStr.split(" - ")[0];
        List<Entrenador> todos = DataManager.cargarEntrenadores();
        String usuarioEnt = "";
        for (Entrenador e : todos) {
            // Buscar coincidencia de nombre para obtener el usuario del entrenador
            if (e.getNombre().equals(nombreEnt)) { usuarioEnt = e.getUsuario(); break; }
        }

        // Crear la cita y guardarla
        Cita cita = new Cita(cliente.getUsuario(), usuarioEnt, fecha, hora, motivo);
        DataManager.guardarCita(cita);

        // Mostrar mensaje de confirmacion y volver al menu del cliente
        JOptionPane.showMessageDialog(this,
                "Cita agendada exitosamente.\nEntrenador: " + entrenadorStr +
                "\nFecha: " + fecha + "  Hora: " + hora,
                "Cita confirmada", JOptionPane.INFORMATION_MESSAGE);
        new MenuCliente(cliente);
        dispose();
    }
}
