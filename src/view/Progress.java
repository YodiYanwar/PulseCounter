/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author YODIEYS
 */
public class Progress {
    private JProgressBar JP;
    
    private JFrame frame;

    private JPanel panel;


    public static void main(String[] args) {

        new Progress();
    }


    
public Progress() {

        frame = new JFrame();

        panel = new JPanel();

        panel.setPreferredSize(new Dimension(200, 35));

        JP = new JProgressBar(0, 100);

        JP.setStringPainted(true);

        panel.add(JP);


        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);

        frame.pack();

        frame.setVisible(true);

        Task();
    }



    public void Task() {

        for (int i = 0; i <= 100; i++) {

            try {

                JP.setValue(i);

                Thread.sleep(50);

            } catch (Exception e) {

            }

        }

    }


}
