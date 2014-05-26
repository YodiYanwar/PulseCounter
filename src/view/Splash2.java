/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.alee.laf.WebLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author YODIEYS
 */
public class Splash2 extends javax.swing.JFrame {

    private Timer timer;
    private int i=1;
    
    
    public Splash2() {
        
//        try{
//            com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme("Default","Java Swing","");
//            UIManager.setLookAndFeel(new NoireLookAndFeel());
//        }catch(UnsupportedLookAndFeelException e){
//            JOptionPane.showMessageDialog(null, "LookAndFeel Tidak Cocok !\n"+e,"ERROR",0);
//        }
        initComponents();
        setLocationRelativeTo(this);
        progressBar.setStringPainted(true);
        start();
        
    }
    
    
    private void start(){
        try {
                ActionListener al = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    i = i+1;
                    progressBar.setValue(i);
                    if(progressBar.getPercentComplete()==1.0){
                        timer.stop();
                        // untuk menon aktifkan form splash
                        setVisible(false);
                        PulseGUI pls = new PulseGUI();
               
                        pls.setVisible(true);
                    }
                }
            };
            timer = new javax.swing.Timer(55, al);
            timer.start();
        } catch(Exception ex) {
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/java 512x288 PC.png"))); // NOI18N

        progressBar.setMaximum(101);
        progressBar.setMinimumSize(new java.awt.Dimension(10, 15));
        progressBar.setPreferredSize(new java.awt.Dimension(180, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
      
              UIManager.setLookAndFeel(WebLookAndFeel.class
                            .getCanonicalName());
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
