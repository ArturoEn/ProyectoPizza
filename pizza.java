
package Pizza;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



public class pizza extends javax.swing.JFrame {

    public pizza() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    DefaultTableModel modelo;
    String prod;
    int precio;
    int precioDos;
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    /*
    private void ordenarTablaPorPrecio() {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> ordenador = new TableRowSorter<>(modelo);
    jTable1.setRowSorter(ordenador);
    
    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    int columnIndexToSort = 1;

    sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
    ordenador.setSortKeys(sortKeys);
    ordenador.sort();
}*/
    


    private void initComponents() {

        size = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblexgrande = new javax.swing.JRadioButton();
        lblchica = new javax.swing.JRadioButton();
        lblmed = new javax.swing.JRadioButton();
        lblgrande = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpago = new javax.swing.JFormattedTextField(new DecimalFormat("#0.00"));
        txtcambio = new javax.swing.JFormattedTextField(new DecimalFormat("#0.00"));
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        txtpago.setEnabled(false);



        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        size.add(lblexgrande);
        lblexgrande.setFont(new java.awt.Font("Dialog", 1, 13));
        lblexgrande.setText("Extra Grande");
        lblexgrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblexgrandeActionPerformed(evt);
            }
        });

        size.add(lblchica);
        lblchica.setFont(new java.awt.Font("Dialog", 1, 13));
        lblchica.setText("Chica");
        lblchica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblchicaActionPerformed(evt);
            }
        });

        size.add(lblmed);
        lblmed.setFont(new java.awt.Font("Dialog", 1, 13));
        lblmed.setText("Mediana");

        size.add(lblgrande);
        lblgrande.setFont(new java.awt.Font("Dialog", 1, 13));
        lblgrande.setText("Grande");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblexgrande)
                    .addComponent(lblmed)
                    .addComponent(lblchica)
                    .addComponent(lblgrande))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblchica)
                .addGap(31, 31, 31)
                .addComponent(lblmed)
                .addGap(31, 31, 31)
                .addComponent(lblgrande)
                .addGap(29, 29, 29)
                .addComponent(lblexgrande)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jTable1.setBackground(new java.awt.Color(80, 185, 185));
        jTable1.setFont(new java.awt.Font("Roboto Black", 4, 15));
        jTable1.setForeground(new java.awt.Color(0,0,0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 97, 575, 269));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 384, 74, 40));

        txtcantidad.setFont(new java.awt.Font("Dialog", 1, 13));
        txtcantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 80, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel3.setText("Pago");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 176, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel4.setText("Cambio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 249, -1, -1));

        txtpago.setFont(new java.awt.Font("Dialog", 1, 13));
        getContentPane().add(txtpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 206, 109, 31));

        txtcambio.setFont(new java.awt.Font("Dialog", 0, 13));
        getContentPane().add(txtcambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 285, 109, 31));
        txtcambio.setEnabled(false);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 384, 89, 40));

        jButton2.setText("Pago");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 384, -1, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 97, -1, -1));

        txttotal.setFont(new java.awt.Font("Dialog", 1, 13));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 127, 109, 31));

        jButton3.setText("Eliminar");
        jButton3.setForeground(Color.red);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 384, -1, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 48));
        jLabel1.setForeground(new java.awt.Color(74, 148, 148));
        jLabel1.setText("Punto de venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 450, 50));

        //jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        //jLabel6.getColorModel( );
        //jLabel6.setText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 979, 460));
        jLabel6.setForeground(Color.black);
        pack();
        setLocationRelativeTo(null);
    }
    
        private void ordenarTablaPorPrecio() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> ordenador = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(ordenador);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        // Ordenar por columna "Articulo"
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));

        // Ordenar por columna "Precio"
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));

        // Ordenar por columna "Cantidad"
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));

        // Ordenar por columna "Total"
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));

        ordenador.setSortKeys(sortKeys);

        
        ordenador.setComparator(1, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));
        ordenador.setComparator(2, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));
        ordenador.setComparator(3, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));

        
        ordenador.setComparator(0, (Object o1, Object o2) -> {
        String s1 = o1.toString();
        String s2 = o2.toString();

        HashMap<String, Integer> order = new HashMap<>();
        order.put("Chica", 1);
        order.put("Mediana", 2);
        order.put("Grande", 3);
        order.put("Extra Grande", 4);

        int index1 = order.getOrDefault(s1, Integer.MAX_VALUE);
        int index2 = order.getOrDefault(s2, Integer.MAX_VALUE);

        return Integer.compare(index1, index2);
    });

    ordenador.sort(); // Ordenar la tabla
}


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	
        if (!lblchica.isSelected() && !lblmed.isSelected() && !lblgrande.isSelected() && !lblexgrande.isSelected()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un tamaño de pizza.");
        return; // Detiene la ejecución del método si no se ha seleccionado un tamaño
    }
        if(lblchica.isSelected() == true){
            prod = "Chica";
            precio = 40;
    }
        else if(lblmed.isSelected() == true){
            prod = "Mediana";
            precio = 55;
    }
        else if(lblgrande.isSelected() == true){
            prod = "Grande";
            precio = 75;
    }
        else if(lblexgrande.isSelected() == true){
            prod = "Exta grande";
            precio = 95;
    }
        
        int cantidad = Integer.parseInt(txtcantidad.getValue().toString());
        int mult = cantidad * precio;
        
        modelo = (DefaultTableModel)jTable1.getModel();
        modelo.addRow(new Object[]{
            prod,
            precio,
            cantidad,
            mult
            
        });
        
        int sum = 0;
        
        for(int i=0; i<jTable1.getRowCount();i++){
            sum+=Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            
        }
        // Habilitar el campo de pago después de agregar una pizza
        txtpago.setEnabled(true);
        ordenarTablaPorPrecio();
        txttotal.setText(Integer.toString(sum));
        txttotal.setEnabled(false);
        // Luego de agregar, ordenar por artículo, cantidad y total
       // ordenarTablaPorArticuloCantidadTotal();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtpago.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el pago...");
        } else {
        double tot = Double.parseDouble(txttotal.getText());
        double pago = Double.parseDouble(txtpago.getText());

        if (pago < 0) {
            JOptionPane.showMessageDialog(this, "El pago no puede ser negativo");
            return;
        }

        // Verificar si el pago tiene decimales
        if (pago == (int) pago) {
            // Si es un número entero, mostrar sin decimales
            txtpago.setText(String.valueOf((int) pago));
        } else {
            // Si tiene decimales, mostrar con dos decimales
            String formattedPago = String.format(Locale.US, "%.2f", pago);
            txtpago.setText(formattedPago);
        }

        double cambio = 0;

        if (pago < tot) {
            JOptionPane.showMessageDialog(null, "Pago menor al monto TOTAL!");
        } else {
            cambio = pago - tot;

            // Verificar si el cambio tiene decimales
            if (cambio == (int) cambio) {
                // Si es un número entero, mostrar sin decimales
                txtcambio.setText(String.valueOf((int) cambio));
            } else {
                // Si tiene decimales, mostrar con dos decimales
                String formattedCambio = String.format(Locale.US, "%.2f", cambio);
                txtcambio.setText(formattedCambio);
            }

            ventas();
        }
    }
}

    public void ventas(){
        int ultid = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pizza", "root","");
            
            String total = txttotal.getText();
            String cambio = txtcambio.getText();
            String pago = txtpago.getText();
            
            
            String consulta = "insert into ventas(subtotal,pago,cambio)values(?,?,?)";
            pst = con.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,total);
            pst.setString(2,pago);
            pst.setString(3,cambio);
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                ultid = rs.getInt(1);
                
            }
            int row =jTable1.getRowCount();
            
            
            String consulta1 = "insert into venta_producto(ventas_id,nombreproducto,precio,cantidad,total)values(?,?,?,?,?)";
            pst1 = con.prepareStatement(consulta1);
            
            String nombreprod ="";
            int precio;
            int cantidad;
            int tot =0;
            
            for(int i=0; i<jTable1.getRowCount();i++)
            {
                nombreprod = (String)jTable1.getValueAt(i, 0);
                precio = (int)jTable1.getValueAt(i, 1);
                cantidad = (int)jTable1.getValueAt(i, 2);
                tot = (int)jTable1.getValueAt(i, 3);
                
                pst1.setInt(1, ultid);
                pst1.setString(2,nombreprod);
                pst1.setInt(3, precio);
                pst1.setInt(4, cantidad);
                pst1.setInt(5,tot);
                pst1.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(this, "Orden Completa");

            // Limpiar la tabla después de completar la venta
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Elimina todas las filas de la tabla

            // También puedes limpiar los campos de pago, cambio y total si es necesario
            txtpago.setText("");
            txtcambio.setText("");
            txttotal.setText("");
            HashMap a = new HashMap();
            a.put("invo", ultid);
          
            try {
    JasperDesign jdesing = JRXmlLoader.load("C:\\Users\\A\\Documents\\Programacion Avanzada\\proyecto\\Pizza\\src\\Pizza\\report1.jrxml");
    JasperReport jreporte = JasperCompileManager.compileReport(jdesing);
    JasperPrint jimp = JasperFillManager.fillReport(jreporte, a, con);

    JasperViewer jasperViewer = new JasperViewer(jimp, false);
    jasperViewer.setVisible(true);

    // Agregar un WindowListener para detectar el cierre de la ventana
    jasperViewer.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            
            
            jasperViewer.setVisible(false);
        }
    });
} catch (JRException ex) {
    Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
}


        } catch (ClassNotFoundException ex) {
        // Manejo de excepciones
        } catch (SQLException ex) {
        // Manejo de excepciones
    }
}

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow >= 0) { // Verificar si hay una fila seleccionada
        modelo.removeRow(selectedRow);
        
        int sum = 0;
        for (int a = 0; a < jTable1.getRowCount(); a++) {
            sum += Integer.parseInt(jTable1.getValueAt(a, 3).toString());
        }

        txttotal.setText(Integer.toString(sum));
         } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un articulo para eliminar.");
        }

        // Deshabilitar el campo de pago si no hay elementos en la tabla después de eliminar
        if (jTable1.getRowCount() == 0) {
        txtpago.setEnabled(false);
    }
}


    private void lblchicaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void lblexgrandeActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Login().setVisible(true);
                new pizza().setVisible(true);
            }
        });
        
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton lblchica;
    private javax.swing.JRadioButton lblexgrande;
    private javax.swing.JRadioButton lblgrande;
    private javax.swing.JRadioButton lblmed;
    public static javax.swing.ButtonGroup size;
    private javax.swing.JTextField txtcambio;
    private javax.swing.JSpinner txtcantidad;
    private javax.swing.JTextField txtpago;
    private javax.swing.JTextField txttotal;
    //private javax.swing.JFormattedTextField txtpago;
    //private javax.swing.JFormattedTextField txtcambio;
}
