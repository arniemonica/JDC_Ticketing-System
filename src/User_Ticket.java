
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arnie D
 */
public class User_Ticket extends javax.swing.JFrame {

    /**
     * Creates new form User_Ticket
     */
    public User_Ticket() {
        initComponents();
        Connect();
        changeLabelName();
        Fetch();
        setTable(user_table);
       
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
     public void setTable(JTable t) {
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        t.getTableHeader().setBackground(new Color(228, 57, 39));
        t.getTableHeader().setForeground(new Color(0, 0, 0));
        t.getTableHeader().setOpaque(true);
        t.getColumnModel().getColumn(0).setPreferredWidth(90);
        t.getColumnModel().getColumn(1).setPreferredWidth(200);
        t.getColumnModel().getColumn(2).setPreferredWidth(200);
        t.getColumnModel().getColumn(3).setPreferredWidth(200);
        t.getColumnModel().getColumn(4).setPreferredWidth(200);
        t.getColumnModel().getColumn(5).setPreferredWidth(200);
        t.getColumnModel().getColumn(6).setPreferredWidth(200);
        t.getColumnModel().getColumn(7).setPreferredWidth(200);
        t.getColumnModel().getColumn(8).setPreferredWidth(200);
        t.getColumnModel().getColumn(9).setPreferredWidth(200);
    }
    public void changeLabelName(){
      String name = Ticketing.user.getText();
      try{
          pst = con.prepareStatement("Select * from users where user_name=? ");
          pst.setString(1, name);
          rs=pst.executeQuery();
          if(rs.next()){
              String first_name = rs.getString("first_name");
              jLabel1.setText("Hi! " + first_name);
          }
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);

        }
      
    }
    public void getEmail(){
        String mail = Ticketing.user.getText();
      try{
          pst = con.prepareStatement("Select * from users where user_name=? ");
          pst.setString(1, mail);
          rs=pst.executeQuery();
          if(rs.next()){
              String email = rs.getString("email");
              
          }
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
     private void Fetch() {
        String mail = Ticketing.user.getText();
        String email = null;
      try{
          pst = con.prepareStatement("Select * from users where user_name=? ");
          pst.setString(1, mail);
          rs=pst.executeQuery();
          if(rs.next()){
               email = rs.getString("email");
              
          }
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);

        }
         try {
            int a;
            pst = con.prepareStatement("SELECT * FROM tickets where email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) user_table.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int x = 1; x <= a; x++) {
                    v2.add(rs.getString("Ticket_ID"));
                    v2.add(rs.getString("Requester"));
                    v2.add(rs.getString("Email"));
                    v2.add(rs.getString("Subject"));
                    v2.add(rs.getString("Message"));
                    v2.add(rs.getString("Department"));
                    v2.add(rs.getString("Assignee"));
                    v2.add(rs.getString("Status"));
                    v2.add(rs.getString("Sent"));
                    v2.add(rs.getString("Status_Change"));
                }
                df.addRow(v2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_table.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket_ID", "Requester", "Email", "Subject", "Message", "Department", "Assignee", "Status", "Sent", "Status Change"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        user_table.getTableHeader().setReorderingAllowed(false);
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(user_table);
        if (user_table.getColumnModel().getColumnCount() > 0) {
            user_table.getColumnModel().getColumn(0).setResizable(false);
            user_table.getColumnModel().getColumn(1).setResizable(false);
            user_table.getColumnModel().getColumn(2).setResizable(false);
            user_table.getColumnModel().getColumn(3).setResizable(false);
            user_table.getColumnModel().getColumn(4).setResizable(false);
            user_table.getColumnModel().getColumn(5).setResizable(false);
            user_table.getColumnModel().getColumn(6).setResizable(false);
            user_table.getColumnModel().getColumn(7).setResizable(false);
            user_table.getColumnModel().getColumn(8).setResizable(false);
            user_table.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 830, 400));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 860, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 40));

        register.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        register.setText("Add Ticket");
        register.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, -1));

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1090, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        Send_Ticket send = new Send_Ticket();
        send.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Ticketing ticket = new Ticketing();
        ticket.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked
        int row = user_table.getSelectedRow();
            Object ID = user_table.getModel().getValueAt(row, 0).toString();
            Object req = user_table.getModel().getValueAt(row, 1).toString();
            Object email = user_table.getModel().getValueAt(row, 2).toString();
            Object sub = user_table.getModel().getValueAt(row, 3).toString();
            Object msg = user_table.getModel().getValueAt(row, 4).toString();
            Object dep = user_table.getModel().getValueAt(row, 5).toString();
            Object assign = user_table.getModel().getValueAt(row, 6).toString();
            Object stats = user_table.getModel().getValueAt(row, 7).toString();
            Object sent = user_table.getModel().getValueAt(row, 8).toString();

           
            View v = new View();
            v.setVisible(true);
            this.dispose();
            View.ID.setText("" + ID);
            View.requester.setText("" + req);
            View.email.setText("" + email);
            View.subject.setText("" + sub);
            View.msg.setText("" + msg);
            View.department.setSelectedItem(dep);
            View.access.setSelectedItem(assign);
            View.stats.setText("" + stats);
            View.date.setText("" + sent);

    }//GEN-LAST:event_user_tableMouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       
       this.setLocation(x-xMouse,y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

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
            java.util.logging.Logger.getLogger(User_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton register;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
