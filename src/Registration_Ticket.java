
import java.awt.Color;
import java.awt.Image;
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
import javax.swing.JPasswordField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arnie D
 */
public class Registration_Ticket extends javax.swing.JFrame {

    /**
     * Creates new form Registration_Ticket
     */
    public Registration_Ticket() {
        initComponents();
        Connect();
        String sign = "<HTML><u>Already have an account. Log in?</u><HTML>";
        jLabel6.setText(sign);
        
        Icon logo = jLabel5.getIcon();
        ImageIcon icon_logo = (ImageIcon) logo;
        Image image_logo = icon_logo.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(image_logo));
    }
    Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs,rs1;
    int xMouse;
    int yMouse;
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
        register = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        showPass = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        first_name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        last_name = new javax.swing.JTextField();
        department = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        access = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        confirm_pass = new javax.swing.JPasswordField();
        show_confirm = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        app_pass = new javax.swing.JPasswordField();
        show_confirm1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 57, 39));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.jpg"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 810, 90));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 90));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(228, 57, 39));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password:");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        register.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        register.setText("Register");
        register.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel8.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 140, -1));

        password.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 330, 37));

        showPass.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        showPass.setForeground(new java.awt.Color(255, 255, 255));
        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        jPanel8.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Department:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("First Name:");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        first_name.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        first_name.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        first_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 330, 37));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Last Name");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        last_name.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        last_name.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        last_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 330, 37));

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT Department", "HR Department", "Admin Department", "Purchasing Department", "Treasury Department" }));
        jPanel8.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 330, 37));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Level of Access:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        access.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        jPanel8.add(access, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 330, 37));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username:");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        username.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 330, 37));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Confirm Password:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        confirm_pass.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        confirm_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(confirm_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 330, 37));

        show_confirm.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        show_confirm.setForeground(new java.awt.Color(255, 255, 255));
        show_confirm.setText("Show Password");
        show_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_confirmActionPerformed(evt);
            }
        });
        jPanel8.add(show_confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Already have an account. Log in?");
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
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        email.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 330, 37));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("App Password:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        app_pass.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        app_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(app_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 330, 37));

        show_confirm1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        show_confirm1.setForeground(new java.awt.Color(255, 255, 255));
        show_confirm1.setText("Show Password");
        show_confirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_confirm1ActionPerformed(evt);
            }
        });
        jPanel8.add(show_confirm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 460));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 800, 480));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        String first = first_name.getText();
        String last = last_name.getText();
        String dept = department.getSelectedItem().toString();
        String lvl = access.getSelectedItem().toString();
        String us = username.getText();
        String pas1 = password.getText();
        String pas = confirm_pass.getText();
        String app = app_pass.getText();
        String mail = email.getText();

        if (first.equals("") || last.equals("") || us.equals("") || pas.equals("") || mail.equals("") || app.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input all the necessary information", "Hey!", JOptionPane.ERROR_MESSAGE);
            first_name.requestFocus();
        } else {
            try {
                pst = con.prepareStatement("Select * from users where user_name = ?");
                pst.setString(1, us);
                rs = pst.executeQuery();
                
                pst1 = con.prepareStatement("Select * from users where email = ?");
                pst1.setString(1,mail);
                rs1 =pst1.executeQuery();
                
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already used.", "Hey!", JOptionPane.ERROR_MESSAGE);
                    username.requestFocus();
                }else if(rs1.next()){
                    JOptionPane.showMessageDialog(null, "Email already used.", "Hey!", JOptionPane.ERROR_MESSAGE);
                    email.requestFocus();
                }else { 
                    if (!pas.equals(pas1)) {
                        JOptionPane.showMessageDialog(null, "Password not match", "Hey!", JOptionPane.ERROR_MESSAGE);
                        password.requestFocus();
                    }
                    
                    else if (lvl.equals("Admin")) {
                        String correctpass = "false";
                        do{
                          JPasswordField acce = new JPasswordField();
                           int result = JOptionPane.showConfirmDialog(null, acce, "Enter Password for Admin", JOptionPane.OK_CANCEL_OPTION);
                           
                               if (result == JOptionPane.OK_OPTION) { 
                            char[] enteredPassword = acce.getPassword();
                            String enteredPasswordStr = new String(enteredPassword).toLowerCase();
                            if (enteredPasswordStr.equals("admin")) {
                                correctpass = "true";
                                 try {
                                pst = con.prepareStatement("Insert into users( first_name,last_name,user_name,password,department,level_of_access, email,app_password) values (?,?,?,?,?,?,?,?)");
                                pst.setString(1, first);
                                pst.setString(2, last);
                                pst.setString(3, us);
                                pst.setString(4, pas);
                                pst.setString(5, dept);
                                pst.setString(6, lvl);
                                pst.setString(7,mail);
                                pst.setString(8, app);
                                int saved = pst.executeUpdate();
                                if (saved == 1) {
                                    JOptionPane.showMessageDialog(this, "Save account");
                                    first_name.setText("");
                                    last_name.setText("");
                                    department.setSelectedIndex(0);
                                    access.setSelectedIndex(0);
                                    username.setText("");
                                    password.setText("");
                                    confirm_pass.setText("");
                                    app_pass.setText("");
                                    Ticketing ticket = new Ticketing();
                                    ticket.setVisible(true);
                                    this.dispose();
                                }

                        } catch (SQLException ex) {
                            Logger.getLogger(Registration_Ticket.class.getName()).log(Level.SEVERE, null, ex);
                            
                        }
                           }else{
                            JOptionPane.showMessageDialog(null, "Wrong password", "Hey!", JOptionPane.ERROR_MESSAGE);
                           
                        }
                            
                        }  
                        }while(!correctpass.equals("true"));
                           
                        
                        
                     
                        
                        }
                    else {
                        try {
                            pst = con.prepareStatement("Insert into users( first_name,last_name,user_name,password,department,level_of_access, email,app_password) values (?,?,?,?,?,?,?,?)");
                            pst.setString(1, first);
                            pst.setString(2, last);
                            pst.setString(3, us);
                            pst.setString(4, pas);
                            pst.setString(5, dept);
                            pst.setString(6, lvl);
                            pst.setString(7, mail);
                            pst.setString(8, app);
                            int saved = pst.executeUpdate();
                            if (saved == 1) {
                                JOptionPane.showMessageDialog(this, "Save account");
                                first_name.setText("");
                                    last_name.setText("");
                                    department.setSelectedIndex(0);
                                    access.setSelectedIndex(0);
                                    username.setText("");
                                    password.setText("");
                                    confirm_pass.setText("");
                                    app_pass.setText("");
                                    Ticketing ticket = new Ticketing();
                                    ticket.setVisible(true);
                                    this.dispose();
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(Registration_Ticket.class.getName()).log(Level.SEVERE, null, ex);

                        }

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Registration_Ticket.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        
    }//GEN-LAST:event_registerActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if(showPass.isSelected()){
            password.setEchoChar((char)0);
        }
        else{
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void show_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_confirmActionPerformed
       if(show_confirm.isSelected()){
            confirm_pass.setEchoChar((char)0);
        }
        else{
            confirm_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_show_confirmActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.dispose();
        Ticketing ticket = new Ticketing();
        ticket.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setForeground(new Color(0,0,0));

    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       
       this.setLocation(x-xMouse,y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
       xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void show_confirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_confirm1ActionPerformed
       if(show_confirm1.isSelected()){
            app_pass.setEchoChar((char)0);
        }
        else{
            app_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_show_confirm1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> access;
    private javax.swing.JPasswordField app_pass;
    private javax.swing.JPasswordField confirm_pass;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JTextField email;
    private javax.swing.JTextField first_name;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField last_name;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JCheckBox show_confirm;
    private javax.swing.JCheckBox show_confirm1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
