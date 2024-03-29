
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arnie D
 */
public class Ticketing extends javax.swing.JFrame {

    /**
     * Creates new form Ticketing
     */
    public Ticketing() {
        initComponents();
        Connect();
        
        String sign = "<HTML><u>I don't have an account. Sign up?</u><HTML>";
        jLabel6.setText(sign);
        Icon logo = jLabel5.getIcon();
        ImageIcon icon_logo = (ImageIcon) logo;
        Image image_logo = icon_logo.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(image_logo));
    }
     Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs,rs1;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tickets_jdc", "root", "admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ticketing.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        showPass = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 57, 39));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.jpg"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 90));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 90));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(228, 57, 39));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password:");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 122, -1, -1));

        login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login.setText("Log In");
        login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel8.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        user.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        user.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 79, 383, 37));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("I don't have an account. Sign up?");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        pass.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 150, 383, 37));

        showPass.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        showPass.setForeground(new java.awt.Color(255, 255, 255));
        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        jPanel8.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 128, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 42, -1, -1));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 300));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 320));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 500, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
       if(showPass.isSelected()){
           pass.setEchoChar((char)0);
       }
       else{
           pass.setEchoChar('*');
       }
    }//GEN-LAST:event_showPassActionPerformed

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
       jLabel6.setForeground(new Color(0,0,0));
       
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel6MouseExited

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
          
            String us = user.getText();
            String pas = pass.getText();
            
             try{
            //for admin
            pst = con.prepareStatement("Select * from users where user_name = ? and binary password = ? and level_of_access = 'admin'");
            pst.setString(1,us);
            pst.setString(2,pas);
            rs = pst.executeQuery();
            
            //for user
            pst1 = con.prepareStatement("Select * from users where user_name = ? and binary password = ? and level_of_access = 'user'");
            pst1.setString(1,us);
            pst1.setString(2,pas);
            rs1 = pst1.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Sucessfully");
                this.dispose();
                Admin_Ticket admin = new Admin_Ticket();
                admin.setVisible(true);
            }
            else if (rs1.next()){
                JOptionPane.showMessageDialog(null, "Login Sucessfully");
                this.dispose();
                User_Ticket user = new User_Ticket();
                user.setVisible(true);
            }
            else{
                try{
                    pst = con.prepareStatement("Select * from users where user_name = ?");
                    pst.setString(1,us);
                    rs=pst.executeQuery();
                    if(rs.next()){
                         JOptionPane.showMessageDialog(null, "Invalid Password", "Hey!", JOptionPane.ERROR_MESSAGE);
                         pass.setText("");
                         pass.requestFocus();
                    }
                    else{
                         JOptionPane.showMessageDialog(null, "User does not exist", "Hey!", JOptionPane.ERROR_MESSAGE);
                         user.setText("");
                         pass.setText("");
                         user.requestFocus();
                    }
                    
                }catch(Exception e){
            
        }
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_loginActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.dispose();
        Registration_Ticket register = new Registration_Ticket();
        register.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Ticketing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticketing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticketing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticketing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticketing().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pass;
    private javax.swing.JCheckBox showPass;
    public static javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    

    
}
