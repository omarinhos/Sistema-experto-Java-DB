package vistas;

import clases.Filtro;
import conexion.Consultas;
import clases.Operaciones;
import clases.Persona;
import clases.Preguntas;
import clases.Repertorio;
import clases.Respuestas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    Repertorio repertorio;
    Preguntas preguntas;
    Respuestas respuestas;
    Operaciones op;
    Consultas consultas;

    DefaultListModel<String> model2;
    DefaultTableModel model;
    DefaultTableModel modelFiltro;

    Icon icon[];
    SimpleDateFormat formatter;

    public Main() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        //Asigna formato Año - mes - dia a la fecha
        formatter = new SimpleDateFormat("yyyy/MM/dd");

        repertorio = new Repertorio();
        preguntas = new Preguntas();
        op = new Operaciones();
        consultas = new Consultas();

        model = new DefaultTableModel();
        modelFiltro = new DefaultTableModel();
        model2 = new DefaultListModel<String>();
        lista2.setModel(model2);

        //Titulos de la tabla
        String[] sa = {"DNI", "Apellidos", "Nombres", "Edad", "Porcentaje", "Diabetes", "Fecha"};
        model.setColumnIdentifiers(sa);
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(55);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(110);
        //Se cargan los iconos desde internet
        icon = new Icon[8];
        try {
            icon[0] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/2554/2554492.png"));
            icon[1] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/4807/4807849.png"));
            icon[2] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/3030/3030914.png"));
            icon[3] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/2117/2117180.png"));
            icon[4] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/4805/4805887.png"));
            icon[5] = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/4354/4354623.png"));
            icon[6] = new ImageIcon(new URL("https://image.flaticon.com/icons/png/128/18/18537.png"));
            icon[7] = new ImageIcon(new URL("https://surgicorperu.com/wp-content/uploads/2021/05/herida.png"));
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        }

        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();

        ArrayList<String> departamentos = new ArrayList<>();
        departamentos = consultas.comboDep();
        for (int i = 0; i < departamentos.size(); i++) {
            jComboBox1.addItem(departamentos.get(i));
        }

        ArrayList<String> provincias = new ArrayList<>();
        provincias = consultas.comboPro();
        for (int i = 0; i < provincias.size(); i++) {
            jComboBox2.addItem(provincias.get(i));
        }

        tablaFiltro();
        
    }

    void mostrarDatos() {
        preguntas = new Preguntas();
        repertorio = new Repertorio();
        respuestas = new Respuestas();

        //Se obtiene las respuestas de cada persona desde la base de datos
        for (int i = 0; i < consultas.cantPersonas(); i++) {
            consultas.respuestas(i + 1, preguntas);
        }
        //Se obtiene las personas desde la base de datos
        for (int i = 0; i < consultas.cantPersonas(); i++) {
            consultas.personas(i + 1, repertorio, preguntas, op);
        }

        //Limpia la tabla
        int nRow = model.getRowCount();
        for (int i = nRow - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        //muestra los datos
        for (int i = 0; i < repertorio.getRepertorio().size(); i++) {
            model.addRow(new Object[]{
                repertorio.getRepertorio().get(i).getDNI(),
                repertorio.getRepertorio().get(i).getApellidos(),
                repertorio.getRepertorio().get(i).getNombres(),
                repertorio.getRepertorio().get(i).getEdad(),
                repertorio.getRepertorio().get(i).getPorcentaje(),
                repertorio.getRepertorio().get(i).getTieneDiabetes(),
                repertorio.getRepertorio().get(i).newFecha()
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        btnProcesar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtfoto = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jlbADNI = new javax.swing.JLabel();
        jlbACor = new javax.swing.JLabel();
        jlbAAp = new javax.swing.JLabel();
        jlbANom = new javax.swing.JLabel();
        jlbAFe = new javax.swing.JLabel();
        jlbATe = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFiltro = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        filtro1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        filtro2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        filtro3 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane4.setBackground(new java.awt.Color(56, 91, 189));
        jTabbedPane4.setPreferredSize(new java.awt.Dimension(838, 677));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setMaximumSize(new java.awt.Dimension(833, 605));
        jPanel3.setPreferredSize(new java.awt.Dimension(833, 605));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel1.setText("Apellidos");
        jLabel1.setPreferredSize(new java.awt.Dimension(64, 26));

        txtApellidos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtApellidos.setMinimumSize(new java.awt.Dimension(6, 23));
        txtApellidos.setPreferredSize(new java.awt.Dimension(6, 26));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel2.setText("Nombres");
        jLabel2.setPreferredSize(new java.awt.Dimension(62, 26));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel3.setText("Fecha nac.");
        jLabel3.setPreferredSize(new java.awt.Dimension(72, 26));

        txtNombres.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNombres.setPreferredSize(new java.awt.Dimension(6, 26));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        btnProcesar.setBackground(new java.awt.Color(204, 255, 255));
        btnProcesar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnProcesar.setText("REGISTRAR");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel15.setText("DNI");
        jLabel15.setPreferredSize(new java.awt.Dimension(24, 26));

        txtDni.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDni.setMinimumSize(new java.awt.Dimension(6, 23));
        txtDni.setPreferredSize(new java.awt.Dimension(6, 26));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel16.setText("Teléfono");
        jLabel16.setPreferredSize(new java.awt.Dimension(61, 26));

        txtTelefono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTelefono.setPreferredSize(new java.awt.Dimension(6, 26));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel17.setText("Correo");
        jLabel17.setPreferredSize(new java.awt.Dimension(48, 26));

        txtCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCorreo.setPreferredSize(new java.awt.Dimension(6, 26));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setText("Subir Imagen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel14.setText("Foto");
        jLabel14.setPreferredSize(new java.awt.Dimension(31, 26));

        txtfoto.setEditable(false);
        txtfoto.setBackground(new java.awt.Color(255, 255, 255));
        txtfoto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfoto.setPreferredSize(new java.awt.Dimension(6, 26));
        txtfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfotoActionPerformed(evt);
            }
        });

        jDateChooser.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jDateChooser.setPreferredSize(new java.awt.Dimension(87, 26));
        jDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel6.setText("Departamento");
        jLabel6.setPreferredSize(new java.awt.Dimension(98, 26));

        jLabel8.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel8.setText("Provincia");
        jLabel8.setPreferredSize(new java.awt.Dimension(62, 26));

        jLabel9.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel9.setText("Distrito");
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 26));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(56, 26));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(56, 26));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(56, 26));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jlbADNI.setForeground(new java.awt.Color(255, 0, 0));
        jlbADNI.setPreferredSize(new java.awt.Dimension(0, 26));

        jlbACor.setForeground(new java.awt.Color(255, 0, 0));

        jlbAAp.setForeground(new java.awt.Color(255, 0, 0));
        jlbAAp.setPreferredSize(new java.awt.Dimension(0, 26));

        jlbANom.setForeground(new java.awt.Color(255, 0, 0));
        jlbANom.setPreferredSize(new java.awt.Dimension(0, 26));

        jlbAFe.setForeground(new java.awt.Color(255, 0, 0));
        jlbAFe.setPreferredSize(new java.awt.Dimension(0, 26));

        jlbATe.setForeground(new java.awt.Color(255, 0, 0));

        jPanel6.setBackground(new java.awt.Color(187, 248, 248));

        jLabel5.setFont(new java.awt.Font("Square721 BT", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(4, 4, 145));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PREDIAGNOSTICO DE DIABETES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(22, 22, 22))
        );

        jPanel7.setBackground(new java.awt.Color(255, 248, 244));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbAAp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbANom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbAFe, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbADNI, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbATe, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbACor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(txtfoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlbAAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbANom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbAFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbADNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbATe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbACor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        jTabbedPane4.addTab("Registro", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 248, 244));

        lista2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        lista2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lista2);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jButton1.setText("Actualizar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jButton2.setText("Generar Archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel19.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("REGISTRO DE PERSONAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("RESPUESTAS");

        jLabel18.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("FOTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(87, 87, 87))
        );

        jTabbedPane4.addTab("Reporte", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tablaFiltro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tablaFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaFiltro);

        jPanel8.setBackground(new java.awt.Color(187, 247, 247));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("FILTRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tiene Diabetes");

        filtro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No filtrar", "Si", "No" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Distrito");

        filtro2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No filtrar", "Cáceres del Perú", "Chimbote", "Coishco", "Macate", "Moro", "Nepeña", "Nuevo Chimbote", "Samanco", "Santa" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Edad");

        filtro3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No filtrar", ">= 18", "< 18" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtro1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtro2, 0, 126, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtro3, 0, 126, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(filtro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane4.addTab("Filtrado", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void Validar(){
        if (txtNombres.getText().isEmpty()){
            jlbANom.setText("*Campo vacío");
        }
        else jlbANom.setText("");
        
        if (txtApellidos.getText().isEmpty()){
            jlbAAp.setText("*Campo vacío");
        }
        else jlbAAp.setText("");
        
        if (txtDni.getText().length() < 7){
            jlbADNI.setText("*DNI no válido");
        }
        else jlbADNI.setText("");
        
        if (txtTelefono.getText().isEmpty()){
            jlbATe.setText("*Campo vacío");
        }
        else jlbATe.setText("");
        
        if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")){
            jlbACor.setText("*Correo no válido");
        }
        else jlbACor.setText("");
        
    }
    

    private void lista2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista2MouseClicked
        try {
            //Se obtiene la persona y pregunta a modificar
            int persona = jTable1.getSelectedRow();
            int pregunta = lista2.getSelectedIndex();

            //Muestra la pregunta seleccionada para actualizar
            String opcion = (String) JOptionPane.showInputDialog(
                    null, op.getPreguntas()[pregunta], "Elegir",
                    JOptionPane.QUESTION_MESSAGE, icon[pregunta], op.getFrecuencia(),
                    op.getFrecuencia()[0]);
            //Se guarda el id de la nueva respusta
            int respuesta = op.setIdRespuesta(opcion);

            //Consulta a la base de datos
            consultas.actualizar((persona + 1), (pregunta + 1), respuesta);
            //limpia la lista de respuetas   
            model2.clear();

            JOptionPane.showMessageDialog(null, "Respuesta Actualizada");
            mostrarDatos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Seleccionar una opción");
        }
    }//GEN-LAST:event_lista2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Document doc = new Document();

        try {
            FileOutputStream ficheroPDF = new FileOutputStream("Reporte.pdf");
            PdfWriter.getInstance(doc, ficheroPDF);

            doc.open();

            Paragraph titulo = new Paragraph("Reporte General\n\n",
                    FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLUE)
            );
            doc.add(titulo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.setHorizontalAlignment(1);
            tabla.addCell("DNI");
            tabla.addCell("Apellidos");
            tabla.addCell("Nombres");
            tabla.addCell("Edad");
            tabla.addCell("Porcentaje");
            tabla.addCell("Diabetes");

            for (int i = 0; i < repertorio.getRepertorio().size(); i++) {
                tabla.addCell(repertorio.getRepertorio().get(i).getDNI());
                tabla.addCell(repertorio.getRepertorio().get(i).getApellidos());
                tabla.addCell(repertorio.getRepertorio().get(i).getNombres());
                tabla.addCell("" + repertorio.getRepertorio().get(i).getEdad());
                tabla.addCell(repertorio.getRepertorio().get(i).getPorcentaje() + "%");
                tabla.addCell("" + repertorio.getRepertorio().get(i).getTieneDiabetes());
            }
            doc.add(tabla);

            for (int i = 0; i < repertorio.getRepertorio().size(); i++) {
                String nombres = "";
                
                nombres += repertorio.getRepertorio().get(i).getDNI() + " ";
                nombres += repertorio.getRepertorio().get(i).getApellidos() + " ";
                nombres += repertorio.getRepertorio().get(i).getNombres() + "\n";
                Paragraph alo = new Paragraph(nombres,
                    FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)
                );
                doc.add(alo);
                String aux = "";
                for (int j = 0; j < 8; j++) {
                    
                    aux += (j + 1) + " - " + op.getPreguntas()[j] + "\n";
                    aux += preguntas.getPreguntas().get(i).getRespuestas().get(j) + "\n";
                }
                aux += "----------------------------------------------------------------------------------------------------------------------------------\n";
                Paragraph alo2 = new Paragraph(aux);
                doc.add(alo2);
            }

            

            doc.close();
            System.out.println("Archivo Generado");
        } catch (DocumentException e) {
            System.out.println(e.toString());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //se captura el id de la persona
        int x = jTable1.getSelectedRow();
        model2.clear(); // limpia la lista de respuestas
        //agrega las respuestas de la persona seleccionada
        for (int i = 0; i < 8; i++) {
            model2.addElement(preguntas.getPreguntas().get(x).getRespuestas().get(i));
        }
        //muestra la foto de la persona seleccionada
        Image foto = getToolkit().getImage(repertorio.getRepertorio().get(x).getUrlFoto());
        foto = foto.getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        lblfoto.setIcon(new ImageIcon(foto));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ArrayList<Filtro> lista = new ArrayList<>();
        String tieneDiabetes;
        String distrito;
        int edad;
        
        if (filtro1.getSelectedItem().equals("No filtrar")) {
            tieneDiabetes = "";
        } else{
            tieneDiabetes = filtro1.getSelectedItem().toString();
        }
        if (filtro2.getSelectedItem().equals("No filtrar")) {
            distrito = "";
        } else{
            distrito = filtro2.getSelectedItem().toString();
        }
        if (filtro3.getSelectedItem().equals("No filtrar")) {
            edad = -1;
        } else if (filtro3.getSelectedItem().equals(">= 18")){
            edad = 18;
        } else {
            edad = 17;
        }  

        lista = consultas.filtro(tieneDiabetes, distrito, edad);
        
        //Limpia la tabla
        int nRow = modelFiltro.getRowCount();
        for (int i = nRow - 1; i >= 0; i--) {
            modelFiltro.removeRow(i);
        }
        //muestra los datos
        for (int i = 0; i < lista.size(); i++) {
            modelFiltro.addRow(new Object[]{
                lista.get(i).getDNI(),
                lista.get(i).getApellidos(),
                lista.get(i).getNombres(),
                lista.get(i).getEdad(),
                lista.get(i).getDistrito(),
                lista.get(i).getPorcentaje(),
                lista.get(i).getTieneDiabetes()
            });
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        ArrayList<String> distritos = new ArrayList<>();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (jComboBox2.getSelectedItem().equals("Santa")) {
                distritos = consultas.comboDis();
                for (int i = 0; i < distritos.size(); i++) {
                    jComboBox3.addItem(distritos.get(i));
                }
            } else{
                jComboBox3.removeAllItems();
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jDateChooserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserKeyTyped
        Validar();
    }//GEN-LAST:event_jDateChooserKeyTyped

    private void txtfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfotoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
            "Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg"
        );
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Seleccionar Archivo");
        File ruta = new File("C:\\Users\\marin\\OneDrive\\Escritorio\\Proyectos\\ProyectoBD\\src\\img");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            txtfoto.setText(String.valueOf(file));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        Validar();

        if (evt.getKeyChar() == 32) {
            evt.consume();
        }

        if (txtCorreo.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Validar();

        if (evt.getKeyChar() >= 0 && evt.getKeyChar() <= 47
            || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 255) {
            evt.consume();
        }

        if (txtTelefono.getText().length() >= 15) {
            evt.consume();
        }

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo números");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        Validar();

        if (evt.getKeyChar() >= 0 && evt.getKeyChar() <= 47
            || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 255) {
            evt.consume();
        }

        if (txtDni.getText().length() >= 8) {
            evt.consume();
        }

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo números");
        }

    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        int id = consultas.cantPersonas() + 1;
        String DNI = txtDni.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        Date date = null;
        String fNacimiento = null;

        try {
            date = jDateChooser.getDate();
            fNacimiento = formatter.format(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingresar Fecha");
        }

        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String urlFoto = txtfoto.getText();
        int distrito = jComboBox3.getSelectedIndex() + 1;
        respuestas = new Respuestas();

        try {
            if (txtDni.getText().length()<8 || txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
                || jDateChooser.getDate() == null || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtfoto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "LLenar los campos");

            } else {
                int r[] = new int[8];
                //Muestra las preguntas
                for (int i = 0; i < op.getPreguntas().length; i++) {
                    String opcion = (String) JOptionPane.showInputDialog(
                        null, op.getPreguntas()[i], "Elegir",
                        JOptionPane.QUESTION_MESSAGE, icon[i], op.getFrecuencia(),
                        op.getFrecuencia()[0]);
                    r[i] = op.setIdRespuesta(opcion);
                }

                //Se agrega la persona a la base de datos
                consultas.agregarPersona(
                    id, DNI, nombres, apellidos, fNacimiento, telefono, correo, distrito, urlFoto
                );
                //Se agrega las respuestas de la misma persona a la base de datos
                consultas.agregarRespuestas(id, r[0], r[1], r[2], r[3], r[4], r[5], r[6], r[7]);
                //se genera el reporte en la base de datos
                consultas.agregarReporte(id);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccionar una opcion ");
        }

        /*
        txtApellidos.setText("");
        txtNombres.setText("");
        jDateChooser.setDate(null);
        txtDni.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtfoto.setText("");
        */
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        Validar();

        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
            || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 64
            || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
            || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 191) {
            evt.consume();
        }

        if (txtNombres.getText().length() >= 30) {
            evt.consume();
        }

        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        Validar();

        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
            || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 64
            || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
            || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 191) {
            evt.consume();
        }

        if (txtApellidos.getText().length() >= 30) {
            evt.consume();
        }

        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
        }

    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void tablaFiltro(){
        String[] sa = {"DNI", "Apellidos", "Nombres", "Edad", "Distrito", "Porcentaje", "Diabetes"};
        modelFiltro.setColumnIdentifiers(sa);
        tablaFiltro.setModel(modelFiltro);
        tablaFiltro.getColumnModel().getColumn(0).setPreferredWidth(60);
        tablaFiltro.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaFiltro.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaFiltro.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> filtro1;
    private javax.swing.JComboBox<String> filtro2;
    private javax.swing.JComboBox<String> filtro3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbAAp;
    private javax.swing.JLabel jlbACor;
    private javax.swing.JLabel jlbADNI;
    private javax.swing.JLabel jlbAFe;
    private javax.swing.JLabel jlbANom;
    private javax.swing.JLabel jlbATe;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JList<String> lista2;
    private javax.swing.JTable tablaFiltro;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtfoto;
    // End of variables declaration//GEN-END:variables
}
