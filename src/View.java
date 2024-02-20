
import java.awt.Color;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arnie D
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        Connect();
    }
      int xMouse;
    int yMouse;
 Connection con;
    PreparedStatement pst;
    ResultSet rs;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        label_pas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        stats = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        access = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        requester = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(228, 57, 39));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(228, 57, 39));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Requester:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("Email:");
        jPanel3.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        email.setEditable(false);
        email.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 330, 37));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Message:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        subject.setEditable(false);
        subject.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        subject.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        subject.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        subject.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel3.add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 330, 37));

        label_pas.setBackground(new java.awt.Color(228, 57, 39));
        label_pas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_pas.setForeground(new java.awt.Color(228, 57, 39));
        jPanel3.add(label_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 180, 30));

        msg.setEditable(false);
        msg.setColumns(20);
        msg.setLineWrap(true);
        msg.setRows(5);
        msg.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        msg.setMaximumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(msg);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 700, 140));

        stats.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stats.setForeground(new java.awt.Color(255, 255, 255));
        stats.setText(" ");
        jPanel3.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT Department", "HR Department", "Admin Department", "Purchasing Department", "Treasury Department" }));
        department.setEnabled(false);
        department.setOpaque(true);
        jPanel3.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 330, 37));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Department:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        access.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arnie del Rosario", "Monica del Rosario" }));
        access.setEnabled(false);
        access.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessActionPerformed(evt);
            }
        });
        jPanel3.add(access, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 330, 37));

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setText("Back");
        cancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Subject:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Assignee:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText(" ");
        jPanel3.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setText(" ");
        jPanel3.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Date Sent:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ticket ID:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        requester.setEditable(false);
        requester.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        requester.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        requester.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        requester.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel3.add(requester, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 330, 37));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 540));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        String s = Ticketing.user.getText();
        String access = null;
        try{
             pst = con.prepareStatement("Select * from users where user_name = ?");
             pst.setString(1,s);
             rs=pst.executeQuery();
             if(rs.next()){
                 access = rs.getString("level_of_access");
                 
             }
             
            if (access.equals("Admin")) {
                this.dispose();
            } else {
                this.dispose();
                User_Ticket user = new User_Ticket();
                user.setVisible(true);
            }
        }catch(SQLException ex){
            
        }
        
        
    }//GEN-LAST:event_cancelActionPerformed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       
       this.setLocation(x-xMouse,y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ID;
    public static javax.swing.JComboBox<String> access;
    private javax.swing.JButton cancel;
    public static javax.swing.JLabel date;
    public static javax.swing.JComboBox<String> department;
    public static javax.swing.JTextField email;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_pas;
    public static javax.swing.JTextArea msg;
    public static javax.swing.JTextField requester;
    public static javax.swing.JLabel stats;
    public static javax.swing.JTextField subject;
    // End of variables declaration//GEN-END:variables
}
