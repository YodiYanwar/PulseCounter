/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.sun.awt.AWTUtilities;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author YODIEYS
 */
public class Splash extends javax.swing.JFrame {
   private Point point = new Point();
   private Dimension dimension = new Dimension();
   private AudioClip audio;
   private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
   
    public Splash() {
        
        try {
            com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.setTheme("Default", "Java Swing", "");
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        jProgressBar1.setStringPainted(true);
        
        Refresh();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
    }
    private void intfrom(){
          dimension =getSize();
          Shape shape =new RoundRectangle2D.Float(0,0,dimensi.width-50,dimensi.height-50,25,0);
   //     Shape shape =new RoundRectangle2D.Float(0,0,dimensi.width-50,dimensi.height-50,25,0);
        AWTUtilities.setWindowShape(this, shape);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jProgressBar1, new java.awt.GridBagConstraints());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/java 512x288.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 300));
        getContentPane().add(jLabel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ActionListener actionListener;
    private int i = 0;
    private javax.swing.Timer timer = new javax.swing.Timer(100, actionListener);
    private void Refresh(){
        try {
                ActionListener al = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    i = i+1;
                    jProgressBar1.setValue(i);
                    if(jProgressBar1.getPercentComplete()==1.0){
                        timer.stop();
                        // untuk menon aktifkan form splash
                //        setVisible(false);
                //        FormUtama x = new FormUtama();
                  //      x.setLocation(dimensi.width/2 - x.getWidth()/2,dimensi.height/2 - x.getHeight()/2);
                  //      x.setVisible(true);
                    }
                }
            };
            timer = new javax.swing.Timer(30, al);
            timer.start();
        } catch(Exception ex) {
        }
    }
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
