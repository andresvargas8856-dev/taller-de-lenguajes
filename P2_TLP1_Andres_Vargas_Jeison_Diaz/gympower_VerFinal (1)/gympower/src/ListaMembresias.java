/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * Ventana principal para seleccionar una membresia del gimnasio.
 * Incluye el plan, el entrenador, los servicios adicionales y acciones de navegacion.
 */
public class ListaMembresias extends javax.swing.JFrame {
    
    // Logger para capturar errores o informacion de la interfaz de membresias.
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListaMembresias.class.getName());

    /**
     * Constructor de la ventana. Configura y muestra todos los componentes graficos.
     */
    public ListaMembresias() {
        initComponents();
    }

    /**
     * Inicializa los componentes de la interfaz y coloca los controles en la ventana.
     * Este metodo es generado por NetBeans y se ejecuta desde el constructor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Crear los labels, combo boxes, checkboxes y botones que forman la ventana.
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbPlanes = new javax.swing.JComboBox<>();
        cmbEntrenadores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkNutricion = new javax.swing.JCheckBox();
        chkClases = new javax.swing.JCheckBox();
        chkRutina = new javax.swing.JCheckBox();
        ContinuarMembresia = new javax.swing.JButton();
        VolverMembresia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("MEMBRESIAS GYM POWER");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16));
        jLabel2.setText("Seleccione Plan : ");

        cmbPlanes.setFont(new java.awt.Font("Arial", 0, 15));
        cmbPlanes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPlanes.addActionListener(this::cmbPlanesActionPerformed);

        cmbEntrenadores.setFont(new java.awt.Font("Arial", 0, 15));
        cmbEntrenadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEntrenadores.addActionListener(this::cmbEntrenadoresActionPerformed);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16));
        jLabel3.setText("Seleccione Entrenador :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16));
        jLabel4.setText("Servicios Adicionales : ");

        jLabel5.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jLabel5.setText("Total : ");

        chkNutricion.setFont(new java.awt.Font("Arial", 0, 15));
        chkNutricion.setText("Nutricion(+50.000)");

        chkClases.setFont(new java.awt.Font("Arial", 0, 15));
        chkClases.setText("Clases Grupales (40.000)");
        chkClases.addActionListener(this::chkClasesActionPerformed);

        chkRutina.setFont(new java.awt.Font("Arial", 0, 15));
        chkRutina.setText("Rutina Personalizada (+30.000)");

        ContinuarMembresia.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        ContinuarMembresia.setText("Continuar");

        VolverMembresia.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        VolverMembresia.setText("Volver");
        VolverMembresia.addActionListener(this::VolverMembresiaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(chkClases))
                                    .addComponent(chkRutina))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(chkNutricion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContinuarMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VolverMembresia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ContinuarMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cmbPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cmbEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addComponent(VolverMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addComponent(chkRutina)
                        .addGap(12, 12, 12)
                        .addComponent(chkClases)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(chkNutricion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
        );

        setSize(800, 600);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlanesActionPerformed
        // Agrega las opciones de planes disponibles al combo box de planes.
        cmbPlanes.addItem("Mensual - $80.000");
        cmbPlanes.addItem("Trimestral - $210.000");
        cmbPlanes.addItem("Semestral - $390.000");
        cmbPlanes.addItem("Anual - $700.000");
    }//GEN-LAST:event_cmbPlanesActionPerformed

    private void cmbEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEntrenadoresActionPerformed
        // Agrega los nombres de entrenadores disponibles al combo box de entrenadores.
        cmbEntrenadores.addItem("Carlos Ramirez");
        cmbEntrenadores.addItem("Laura Gomez");
        cmbEntrenadores.addItem("Carlos Ramirez");
    }//GEN-LAST:event_cmbEntrenadoresActionPerformed

    private void chkClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkClasesActionPerformed
        // Accion cuando el usuario selecciona o deselecciona la opcion de clases grupales.
        // Aqui se puede calcular el total o habilitar otras opciones.
    }//GEN-LAST:event_chkClasesActionPerformed

    private void VolverMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMembresiaActionPerformed
        // Regresa a la pantalla de inicio y cierra esta ventana de membresias.
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverMembresiaActionPerformed

    /**
     * Punto de entrada de la aplicacion para esta ventana de membresias.
     * Configura el look and feel y muestra la ventana en el hilo de eventos de Swing.
     * @param args argumentos de linea de comandos opcionales
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ListaMembresias().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContinuarMembresia;
    private javax.swing.JButton VolverMembresia;
    private javax.swing.JCheckBox chkClases;
    private javax.swing.JCheckBox chkNutricion;
    private javax.swing.JCheckBox chkRutina;
    private javax.swing.JComboBox<String> cmbEntrenadores;
    private javax.swing.JComboBox<String> cmbPlanes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
