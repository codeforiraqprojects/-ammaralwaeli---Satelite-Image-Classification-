
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainpage extends javax.swing.JFrame {

    BufferedImage img1,result;

    public mainpage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Divide = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("OPEN ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 150, 110, 42);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 60, 700, 390);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Satalite Image Classification");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 10, 350, 36);

        jButton2.setText("Close");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 300, 109, 40);

        Divide.setText("Divide");
        Divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivideActionPerformed(evt);
            }
        });
        getContentPane().add(Divide);
        Divide.setBounds(40, 200, 110, 40);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 580, 0, 0);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save);
        Save.setBounds(40, 250, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        loadimg h = new loadimg();
        String add;
        URL url = null;
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status != JFileChooser.APPROVE_OPTION) // jTextField1.setText("no file");'
        {
            JOptionPane.showMessageDialog(null, "NO Image Selected.");
        } else {
            try {
                File file = chooser.getSelectedFile();
                String name = file.getName();
                if (name.matches(".*((.*)|(.*)|(.*))")) {
                    ////////////geting path//////////
                    add = file.getPath();
                    url = new File(add).toURI().toURL();
                    /////////////////////////////
                    //////////////////reding and presenting image/////////////
                    BufferedImage img = ImageIO.read(url);
                    h.load1(add);
                    jLabel1.setSize(img.getWidth(), img.getHeight());
                    jLabel1.setIcon(new ImageIcon(img));
                    img1 = img;
                    ///////////////////////////////////////////
                    //  ss.si(img);
                }
            } catch (IOException ex) {
                System.out.println("Some IOException accured (did you set the right path?):");
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivideActionPerformed
        Divide d = new Divide();
        d.createAndShowUI(img1);
        result=d.img2;
    }//GEN-LAST:event_DivideActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        save s = new save();
        try {
            s.si(result);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_SaveActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainpage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Divide;
    private javax.swing.JButton Save;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
