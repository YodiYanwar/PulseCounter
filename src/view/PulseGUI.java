/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author YODIEYS
 */
import com.alee.laf.WebLookAndFeel;
import control.Operasi;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;


public class PulseGUI extends javax.swing.JFrame {

        Connection koneksi;
        Statement script;
        DefaultTableModel tabelModel;
        NumberFormat nf;
        
        String str = "";
        int sAwal, sAkhir, omset; 
        
          
    public PulseGUI() {

        initComponents();
        setLocationRelativeTo(this);
        
        String[] judul = {"ID Input","Saldo Awal(Rp.)","Saldo Akhir(Rp.)","Omset(Rp.)","Pemakaian(Rp.)","Laba(Rp.)","Tanggal Input"};
        tabelModel = new DefaultTableModel(judul,0);
        tabel.setModel(tabelModel);
        
        
        koneksiDB();
        
        tampil();
        
        buttonHapus.setEnabled(false);
        
        lblNot1.setVisible(false);
        lblNot2.setVisible(false);
        lblNot3.setVisible(false);
        
        buttonDelete.setEnabled(false);
        buttonEdit.setEnabled(false);
        buttonRefresh.setEnabled(false);
        buttonNew.setEnabled(false);
        buttonSimpan.setEnabled(false);
         
        
    }
    
    void operasi(){
      
        try{
            
        nf = NumberFormat.getInstance().getCurrencyInstance(Locale.US);
        
        nf.setMinimumIntegerDigits(0);
        nf.setGroupingUsed(true);
                  
        sAwal = Integer.parseInt(textSaldoA.getText());
        sAkhir = Integer.parseInt(textSaldoB.getText());
        omset = Integer.parseInt(textOmset.getText());
        
            Operasi op = new Operasi();
            
            op.setSaldoA(sAwal);
            op.setSaldoB(sAkhir);
            op.setOmset(omset);
           
            String hslLaba = op.laba();
            String hslSaldoA = op.getSaldoA();
            String hslSaldoB = op.getSaldoB();
            String hslOmset = op.getOmset();
        
        textLaba.setText(str+hslLaba);
        textSaldoA.setText(str+hslSaldoA);
        textSaldoB.setText(str+hslSaldoB);
        textOmset.setText(str+hslOmset);
        
        textPemakaian.setText(str+op.pemakaian());
        
        buttonHapus.setEnabled(true);
        
       } catch(NumberFormatException ne){
           JOptionPane.showMessageDialog(null,"Input Harus Angka !","ERROR",0);
       }
    }
    
    void verifikasi(){
        if((textSaldoA.getText().equals(str)) && (textSaldoB.getText().equals(str)) && (textOmset.getText().equals(str))){
        JOptionPane.showMessageDialog(null,"Semua Form Masih Kosong !","ERROR",0);
        
        }
       else if((textSaldoA.getText().equals(str)) && (textSaldoB.getText().equals(str))){
        JOptionPane.showMessageDialog(null,"Form Saldo Awal & Saldo Akhir Masih Kosong !","ERROR",0);
        }
       else if((textSaldoA.getText().equals(str)) && (textOmset.getText().equals(str))){
        JOptionPane.showMessageDialog(null,"Form Saldo Awal & Omset Masih Kosong !","ERROR",0);
        }
       else if((textSaldoB.getText().equals(str)) && (textOmset.getText().equals(str))){
        JOptionPane.showMessageDialog(null,"Form Saldo Akhir & Omset Masih Kosong !","ERROR",0);
        } 
       else if(textSaldoA.getText().equals(str)){
           JOptionPane.showMessageDialog(null,"Form Saldo Awal Masih Kosong !","ERROR",0);
       }else if(textSaldoB.getText().equals(str)){
           JOptionPane.showMessageDialog(null,"Form Saldo Akhir Masih Kosong !","ERROR",0);
       }else if(textOmset.getText().equals(str)){
           JOptionPane.showMessageDialog(null,"Form Omset Masih Kosong !","ERROR",0);
       }else{
           operasi();
       }
    }
    
    void verifikasiBtnHapus(){
        
        if(textSaldoA.getText().isEmpty() && textSaldoB.getText().isEmpty() && textOmset.getText().isEmpty()){
            buttonHapus.setEnabled(false);
        }
        
        if(textSaldoA.getText().isEmpty() || textSaldoB.getText().isEmpty() || textOmset.getText().isEmpty()){
            buttonHapus.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerInput = new javax.swing.JLayeredPane();
        labelSaldoA = new javax.swing.JLabel();
        labelSaldoB = new javax.swing.JLabel();
        labelOmset = new javax.swing.JLabel();
        textSaldoA = new javax.swing.JTextField();
        textSaldoB = new javax.swing.JTextField();
        textOmset = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNot2 = new javax.swing.JLabel();
        lblNot3 = new javax.swing.JLabel();
        lblNot1 = new javax.swing.JLabel();
        layerTombol = new javax.swing.JLayeredPane();
        buttonHitung = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        layerLaba = new javax.swing.JLayeredPane();
        labelRpLaba = new javax.swing.JLabel();
        textLaba = new javax.swing.JTextField();
        layerPemakaian = new javax.swing.JLayeredPane();
        labelRpPemakaian = new javax.swing.JLabel();
        textPemakaian = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        buttonRefresh = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        textIdInput = new javax.swing.JTextField();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        textTglInput = new com.toedter.calendar.JDateChooser();
        buttonNew = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuICalc = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        radioTexture = new javax.swing.JRadioButtonMenuItem();
        radioBernstein = new javax.swing.JRadioButtonMenuItem();
        radioNoire = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pulse Counter v2.3");
        setResizable(false);

        layerInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        layerInput.setForeground(new java.awt.Color(153, 153, 153));

        labelSaldoA.setBackground(new java.awt.Color(192, 192, 192));
        labelSaldoA.setForeground(new java.awt.Color(192, 192, 192));
        labelSaldoA.setText("Saldo Awal        Rp.");
        layerInput.add(labelSaldoA);
        labelSaldoA.setBounds(10, 30, 110, 14);

        labelSaldoB.setBackground(new java.awt.Color(0, 0, 0));
        labelSaldoB.setForeground(new java.awt.Color(192, 192, 192));
        labelSaldoB.setText("Saldo Akhir        Rp.");
        layerInput.add(labelSaldoB);
        labelSaldoB.setBounds(10, 70, 110, 14);

        labelOmset.setBackground(new java.awt.Color(0, 0, 0));
        labelOmset.setForeground(new java.awt.Color(192, 192, 192));
        labelOmset.setText("Omset                Rp.");
        layerInput.add(labelOmset);
        labelOmset.setBounds(10, 110, 110, 14);

        textSaldoA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textSaldoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSaldoAActionPerformed(evt);
            }
        });
        textSaldoA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSaldoAKeyTyped(evt);
            }
        });
        layerInput.add(textSaldoA);
        textSaldoA.setBounds(120, 20, 120, 30);

        textSaldoB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textSaldoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSaldoBKeyTyped(evt);
            }
        });
        layerInput.add(textSaldoB);
        textSaldoB.setBounds(120, 60, 120, 30);

        textOmset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textOmset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textOmsetKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textOmsetKeyTyped(evt);
            }
        });
        layerInput.add(textOmset);
        textOmset.setBounds(120, 100, 120, 30);
        layerInput.add(jLabel1);
        jLabel1.setBounds(250, 16, 0, 30);

        lblNot2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNot2.setForeground(new java.awt.Color(180, 50, 0));
        lblNot2.setToolTipText("Input Harus Angka");
        layerInput.add(lblNot2);
        lblNot2.setBounds(250, 60, 30, 30);

        lblNot3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNot3.setForeground(new java.awt.Color(180, 50, 0));
        lblNot3.setToolTipText("Input Harus Angka");
        layerInput.add(lblNot3);
        lblNot3.setBounds(250, 100, 30, 30);

        lblNot1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNot1.setForeground(new java.awt.Color(180, 50, 0));
        lblNot1.setToolTipText("Input Harus Angka");
        layerInput.add(lblNot1);
        lblNot1.setBounds(250, 20, 30, 30);

        layerTombol.setBorder(javax.swing.BorderFactory.createTitledBorder("Tombol"));

        buttonHitung.setText("Hitung");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });
        layerTombol.add(buttonHitung);
        buttonHitung.setBounds(10, 20, 73, 40);

        buttonHapus.setText("Bersih");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        layerTombol.add(buttonHapus);
        buttonHapus.setBounds(92, 20, 80, 40);

        buttonKeluar.setText("Tutup");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });
        layerTombol.add(buttonKeluar);
        buttonKeluar.setBounds(180, 20, 80, 40);

        layerLaba.setBorder(javax.swing.BorderFactory.createTitledBorder("Laba"));

        labelRpLaba.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelRpLaba.setForeground(new java.awt.Color(192, 192, 192));
        labelRpLaba.setText("Rp.");
        layerLaba.add(labelRpLaba);
        labelRpLaba.setBounds(10, 20, 50, 50);

        textLaba.setEditable(false);
        textLaba.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        textLaba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLabaActionPerformed(evt);
            }
        });
        layerLaba.add(textLaba);
        textLaba.setBounds(60, 20, 200, 70);

        layerPemakaian.setBorder(javax.swing.BorderFactory.createTitledBorder("Pemakaian Saldo"));

        labelRpPemakaian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelRpPemakaian.setForeground(new java.awt.Color(192, 192, 192));
        labelRpPemakaian.setText("Rp.");
        layerPemakaian.add(labelRpPemakaian);
        labelRpPemakaian.setBounds(10, 20, 23, 30);

        textPemakaian.setEditable(false);
        textPemakaian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textPemakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPemakaianActionPerformed(evt);
            }
        });
        layerPemakaian.add(textPemakaian);
        textPemakaian.setBounds(60, 20, 200, 30);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel"));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLayeredPane1.add(jScrollPane1);
        jScrollPane1.setBounds(12, 20, 660, 410);

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        jLayeredPane1.add(buttonRefresh);
        buttonRefresh.setBounds(490, 450, 71, 30);

        buttonDelete.setText("Hapus");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        jLayeredPane1.add(buttonDelete);
        buttonDelete.setBounds(410, 450, 63, 30);

        buttonEdit.setText("Edit");
        jLayeredPane1.add(buttonEdit);
        buttonEdit.setBounds(330, 450, 51, 30);

        buttonSimpan.setText("Simpan di Database");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Input"));

        textIdInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textIdInputKeyTyped(evt);
            }
        });
        jLayeredPane2.add(textIdInput);
        textIdInput.setBounds(10, 20, 120, 30);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tanggal Input"));
        jLayeredPane3.add(textTglInput);
        textTglInput.setBounds(30, 20, 91, 20);

        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        menuICalc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuICalc.setText("Calculator");
        menuICalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuICalcActionPerformed(evt);
            }
        });
        jMenu1.add(menuICalc);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("LookAndFeels");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        radioTexture.setSelected(true);
        radioTexture.setText("Texture");
        jMenu2.add(radioTexture);

        radioBernstein.setSelected(true);
        radioBernstein.setText("Bernstein");
        jMenu2.add(radioBernstein);

        radioNoire.setSelected(true);
        radioNoire.setText("Noire");
        jMenu2.add(radioNoire);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(layerPemakaian)
                    .addComponent(layerLaba, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(layerTombol, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(layerInput, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(layerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(layerTombol, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(layerLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(layerPemakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPemakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPemakaianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPemakaianActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        // TODO add your handling code here:
       verifikasi();
       
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void textLabaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLabaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLabaActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        // TODO add your handling code here:
         int app;

//        if ((app = JOptionPane.showConfirmDialog(null, "Tutup Program"
//                + " ?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0) {
//           
//                System.exit(0);
//            
//        }
         if((app = JOptionPane.showConfirmDialog(null,"Tutup Program ?","Perhatian",JOptionPane.YES_NO_OPTION))==0){
             System.exit(0);
         }
        
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void menuICalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuICalcActionPerformed
        // TODO add your handling code here:
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }//GEN-LAST:event_menuICalcActionPerformed

    private void textSaldoBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSaldoBKeyTyped
        // TODO add your handling code here:
        justNumb2(evt);
    }//GEN-LAST:event_textSaldoBKeyTyped

    private void textOmsetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textOmsetKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textOmsetKeyPressed

    private void textOmsetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textOmsetKeyTyped
        // TODO add your handling code here:
        justNumb3(evt);
    }//GEN-LAST:event_textOmsetKeyTyped

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        try{
            com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme("Default","Java Swing","");
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"LookAndFeel ERROR","ERROR",0);
        }
            
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void koneksiDB(){
       
            try{
            String url = "jdbc:mysql://localhost:3306/pulse";
            String user = "root";
            String pswd = "";
        
        
            Class.forName("com.mysql.jdbc.Driver");
            
            koneksi = DriverManager.getConnection(url,user,pswd);
            script = koneksi.createStatement();
            
            System.out.println("Berhasil Membuat Koneksi");
            
            
        } catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Gagal Membuat Koneksi !\n"+e,"ERROR",0);           
        }
            
  }
    
    private void tampil(){
        try {
            int baris = tabelModel.getRowCount();
            for (int i = 0; i < baris; i++) {
                tabelModel.removeRow(0);
            }
            
            String sql = "SELECT * FROM pulsecount";
            ResultSet rs = script.executeQuery(sql);
            
            while(rs.next()){
                String[] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
                
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan !\n"+ex,"ERROR",0);
        }
    }
    
    private void bersih(){
        textLaba.setText(null);
        textOmset.setText(null);
        textPemakaian.setText(null);
        textSaldoA.setText(null);
        textSaldoB.setText(null);
        textIdInput.setText(null);
        textIdInput.setText(null);
        
        buttonHapus.setEnabled(false);
        buttonSimpan.setEnabled(false);
        
        
        lblNot1.setVisible(false);
        lblNot2.setVisible(false);
        lblNot3.setVisible(false);
    }
    
    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        try{
            
            DateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy");
            String tgl = dateFormat.format(this.textTglInput.getDate()); 
        
            String id = textIdInput.getText();
            String saw = textSaldoA.getText();
            String sak = textSaldoB.getText();
            String omst = textOmset.getText();
            String pem = textPemakaian.getText();
            String lab = textLaba.getText();
            
            
            String sql = "INSERT INTO pulsecount VALUES('"+id+"','"+saw+"','"+sak+"','"+omst+"','"+pem+"','"+lab+"','"+tgl+"')";
       
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.executeUpdate();
            
            tampil();
            
            JOptionPane.showMessageDialog(null, "ID Input "+id+" Berhasil Disimpan","SUCSESS",1);
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan\nTerjadi Kesalahan !\n"+e,"ERROR",0);
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
         int app;

        if ((app = JOptionPane.showConfirmDialog(null, "Hapus data"
                + " ?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0) {
            try {
                String sql = "delete from pulsecount where"
                        + " idTrans = '" + textIdInput.getText() + "'";

                PreparedStatement p = koneksi.prepareStatement(sql);
                p.executeUpdate();

                tampil();
                bersih();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                
            } catch (SQLException ex) {
                System.err.print(ex);
            }
        }
        
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int i = tabel.getSelectedRow();
        
        if (i>-1) {
            textIdInput.setText(tabelModel.getValueAt(i, 0).toString());
            textSaldoA.setText(tabelModel.getValueAt(i, 1).toString());
            textSaldoB.setText(tabelModel.getValueAt(i, 2).toString());
            textOmset.setText(tabelModel.getValueAt(i, 3).toString());
            textPemakaian.setText(tabelModel.getValueAt(i, 4).toString());
            textLaba.setText(tabelModel.getValueAt(i, 5).toString());
            
            
        }
        
            buttonDelete.setEnabled(true);
            buttonEdit.setEnabled(true);
            buttonRefresh.setEnabled(true);
            buttonNew.setEnabled(true);
           
    }//GEN-LAST:event_tabelMouseClicked

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_buttonNewActionPerformed

    private void textTglInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTglInputKeyTyped
        // TODO add your handling code here:
        if(!textTglInput.getDateFormatString().isEmpty()){
            buttonSimpan.setEnabled(true);
        }
    }//GEN-LAST:event_textTglInputKeyTyped

    private void textIdInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIdInputKeyTyped
        // TODO add your handling code here:
        if(!textIdInput.getText().isEmpty()){
            buttonSimpan.setEnabled(true);
            buttonNew.setEnabled(true);
            
        } 
        
        if(textIdInput.getText().isEmpty()){
            buttonSimpan.setEnabled(false);
            buttonNew.setEnabled(false);
            
        } 
    }//GEN-LAST:event_textIdInputKeyTyped

    private void textSaldoAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSaldoAKeyTyped
        // TODO add your handling code here:
        justNumb1(evt);

    }//GEN-LAST:event_textSaldoAKeyTyped

    private void textSaldoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSaldoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSaldoAActionPerformed

    private void justNumb1(KeyEvent evt) {
   //     buttonHapus.setEnabled(true);
        verifikasiBtnHapus();
        double c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && textSaldoA.getText().length() < 9)) {
            lblNot1.setVisible(true);
            lblNot1.setText("!");
           getToolkit().beep();               
           
   //        buttonHapus.setEnabled(true);
//            evt.consume();
            
        } 
//        else
//            lblNot1.setVisible(false);
//            lblNot1.setText("");
        
         if(textSaldoA.getText().isEmpty()){
   //         buttonHapus.setEnabled(false);
            lblNot1.setVisible(false);
            lblNot1.setText("");
        }
        
         
        
        
    }
    
    private void justNumb3(KeyEvent evt){
        
  //      buttonHapus.setEnabled(true);
        verifikasiBtnHapus();
        
        double c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && textOmset.getText().length() < 9)) {
            lblNot3.setVisible(true);
            lblNot3.setText("!");
           getToolkit().beep();               
           
   //        buttonHapus.setEnabled(true);
//            evt.consume();
            
        } 
//        else
//            lblNot1.setVisible(false);
//            lblNot1.setText("");
        
         if(textOmset.getText().isEmpty()){
  //          buttonHapus.setEnabled(false);
            lblNot3.setVisible(false);
            lblNot3.setText("");
        }
    }
    
    private void justNumb2(KeyEvent evt){
        
   //     buttonHapus.setEnabled(true);
        verifikasiBtnHapus();
        double c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && textSaldoB.getText().length() < 9)) {
            lblNot2.setVisible(true);
            lblNot2.setText("!");
           getToolkit().beep();               
           
  //         buttonHapus.setEnabled(true);
//            evt.consume();
            
        } 
//        else
//            lblNot1.setVisible(false);
//            lblNot1.setText("");
        
         if(textSaldoB.getText().isEmpty()){
   //         buttonHapus.setEnabled(false);
            lblNot2.setVisible(false);
            lblNot2.setText("");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PulseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PulseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PulseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PulseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(WebLookAndFeel.class
                            .getCanonicalName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PulseGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(PulseGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(PulseGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PulseGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                new PulseGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOmset;
    private javax.swing.JLabel labelRpLaba;
    private javax.swing.JLabel labelRpPemakaian;
    private javax.swing.JLabel labelSaldoA;
    private javax.swing.JLabel labelSaldoB;
    private javax.swing.JLayeredPane layerInput;
    private javax.swing.JLayeredPane layerLaba;
    private javax.swing.JLayeredPane layerPemakaian;
    private javax.swing.JLayeredPane layerTombol;
    private javax.swing.JLabel lblNot1;
    private javax.swing.JLabel lblNot2;
    private javax.swing.JLabel lblNot3;
    private javax.swing.JMenuItem menuICalc;
    private javax.swing.JRadioButtonMenuItem radioBernstein;
    private javax.swing.JRadioButtonMenuItem radioNoire;
    private javax.swing.JRadioButtonMenuItem radioTexture;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField textIdInput;
    private javax.swing.JTextField textLaba;
    private javax.swing.JTextField textOmset;
    private javax.swing.JTextField textPemakaian;
    private javax.swing.JTextField textSaldoA;
    private javax.swing.JTextField textSaldoB;
    private com.toedter.calendar.JDateChooser textTglInput;
    // End of variables declaration//GEN-END:variables
}
