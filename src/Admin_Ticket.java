
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arnie D
 */
public class Admin_Ticket extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Ticket
     */
    public Admin_Ticket() {
        initComponents();
        Connect();
        changeLabelName();
        Fetch();
        setTable(admin_table);
        ret.setEnabled(false);
        setColor(jPanel5);
       
    }
    int xMouse;
    int yMouse;
    String un = "false";
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
    void count(){
        String mail = Ticketing.user.getText();
        String email = null;
        try {
            pst = con.prepareStatement("Select * from users where user_name=? ");
            pst.setString(1, mail);
            rs = pst.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");

            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);

        }
         try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Open' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                open_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Pending' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                pending_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'On Hold' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                hold_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Solved' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                solved_label.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Closed' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                closed_label.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where Assignee_Email != ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                unassigned.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                assigned.setText(count);
            } catch (SQLException ex) {

            }
              try {
                pst = con.prepareStatement("Select count(*) from delete_tickets where Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                trash.setText(count);
            } catch (SQLException ex) {

            }
    }
    private void Fetch() {
        String mail = Ticketing.user.getText();
        String email = null;
        try {
            pst = con.prepareStatement("Select * from users where user_name=? ");
            pst.setString(1, mail);
            rs = pst.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");

            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            int a;
            pst = con.prepareStatement("SELECT * FROM tickets where Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Open' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                open_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Pending' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                pending_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'On Hold' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                hold_label.setText(count);
            } catch (SQLException ex) {

            }
            try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Solved' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                solved_label.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where status = 'Closed' and Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                closed_label.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where Assignee_Email != ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                unassigned.setText(count);
            } catch (SQLException ex) {

            }
             try {
                pst = con.prepareStatement("Select count(*) from tickets where Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                assigned.setText(count);
            } catch (SQLException ex) {

            }
              try {
                pst = con.prepareStatement("Select count(*) from delete_tickets where Assignee_Email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                String count = rs.getString(1);
                trash.setText(count);
            } catch (SQLException ex) {

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User_Ticket.class.getName()).log(Level.SEVERE, null, ex);
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
       private void Fetch_tickets() {
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
      
        String dept = department.getSelectedItem().toString();
         try {
            int a;
            pst = con.prepareStatement("SELECT * FROM tickets where department = ? and Assignee_email=?");
            pst.setString(1, dept);
            pst.setString(2, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
          private void Fetch_tickets1() {
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
      
        String dept = department.getSelectedItem().toString();
         try {
            int a;
            pst = con.prepareStatement("SELECT * FROM tickets where department = ? and Assignee_email!=?");
            pst.setString(1, dept);
            pst.setString(2, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
       public void unassigned(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Assignee_email!=?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
         public void open(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Status='Open' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
      public void pending(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Status='Pending' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
      public void solved(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Status='Solved' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
       public void hold(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Status='On hold' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
     public void closed(){
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
            pst = con.prepareStatement("SELECT * FROM tickets where Status='Closed' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
      public void removed(){
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
            pst = con.prepareStatement("SELECT * FROM delete_tickets where Status='Removed' and Assignee_Email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) admin_table.getModel();
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
     public void setColor(JPanel p) {
        p.setBackground(new Color(195, 0, 0));
    }

    public void resetColor(JPanel p) {
        p.setBackground(new Color(228, 57, 39));
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
        admin_table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        solved = new javax.swing.JButton();
        on_hold = new javax.swing.JButton();
        open = new javax.swing.JButton();
        pending = new javax.swing.JButton();
        department = new javax.swing.JComboBox<>();
        closed = new javax.swing.JButton();
        ret = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pending_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        assigned = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        open_label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        hold_label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        trash = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        solved_label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        closed_label = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        ut_p = new javax.swing.JPanel();
        unassigned = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        check = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        admin_table.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        admin_table.setModel(new javax.swing.table.DefaultTableModel(
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
        admin_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        admin_table.getTableHeader().setReorderingAllowed(false);
        admin_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(admin_table);
        if (admin_table.getColumnModel().getColumnCount() > 0) {
            admin_table.getColumnModel().getColumn(0).setResizable(false);
            admin_table.getColumnModel().getColumn(1).setResizable(false);
            admin_table.getColumnModel().getColumn(2).setResizable(false);
            admin_table.getColumnModel().getColumn(3).setResizable(false);
            admin_table.getColumnModel().getColumn(4).setResizable(false);
            admin_table.getColumnModel().getColumn(5).setResizable(false);
            admin_table.getColumnModel().getColumn(6).setResizable(false);
            admin_table.getColumnModel().getColumn(7).setResizable(false);
            admin_table.getColumnModel().getColumn(8).setResizable(false);
            admin_table.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 830, 400));

        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 150, 40));

        solved.setText("Solved");
        solved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solvedActionPerformed(evt);
            }
        });
        jPanel3.add(solved, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 150, 40));

        on_hold.setText("On Hold");
        on_hold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_holdActionPerformed(evt);
            }
        });
        jPanel3.add(on_hold, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 150, 40));

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPanel3.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 150, 40));

        pending.setText("Pending");
        pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingActionPerformed(evt);
            }
        });
        jPanel3.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 150, 40));

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin Department", "IT Department", "HR Department", "Engineering Department", "Treasury Department", "Purchasing Department", "MSO Department", "Sales and Marketing Department", "Accounting Department", "HRI Department", "Office of the President" }));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });
        jPanel3.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 240, -1));

        closed.setText("Closed");
        closed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closedActionPerformed(evt);
            }
        });
        jPanel3.add(closed, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 150, 40));

        ret.setText("Retrieve");
        ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retActionPerformed(evt);
            }
        });
        jPanel3.add(ret, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 150, 40));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 150, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 870, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 40));

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 150, 40));

        jPanel4.setBackground(new java.awt.Color(228, 57, 39));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pending_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pending_label.setForeground(new java.awt.Color(255, 255, 255));
        pending_label.setText("0");
        jPanel4.add(pending_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pending");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 50));

        jPanel5.setBackground(new java.awt.Color(228, 57, 39));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assigned.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        assigned.setForeground(new java.awt.Color(255, 255, 255));
        assigned.setText("0");
        jPanel5.add(assigned, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Assigned Tickets");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, 10));

        jPanel7.setBackground(new java.awt.Color(228, 57, 39));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        open_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        open_label.setForeground(new java.awt.Color(255, 255, 255));
        open_label.setText("0");
        jPanel7.add(open_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Open");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 220, 50));

        jPanel8.setBackground(new java.awt.Color(228, 57, 39));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hold_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hold_label.setForeground(new java.awt.Color(255, 255, 255));
        hold_label.setText("0");
        jPanel8.add(hold_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("On Hold");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 220, 50));

        jPanel9.setBackground(new java.awt.Color(228, 57, 39));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        trash.setForeground(new java.awt.Color(255, 255, 255));
        trash.setText("0");
        jPanel9.add(trash, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Trash");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 220, 50));

        jPanel10.setBackground(new java.awt.Color(228, 57, 39));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solved_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        solved_label.setForeground(new java.awt.Color(255, 255, 255));
        solved_label.setText("0");
        jPanel10.add(solved_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Solved");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        jPanel11.setBackground(new java.awt.Color(228, 57, 39));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closed_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closed_label.setForeground(new java.awt.Color(255, 255, 255));
        closed_label.setText("0");
        jPanel11.add(closed_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Closed");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 220, 50));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 10));

        ut_p.setBackground(new java.awt.Color(228, 57, 39));
        ut_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ut_pMouseClicked(evt);
            }
        });
        ut_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unassigned.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        unassigned.setForeground(new java.awt.Color(255, 255, 255));
        unassigned.setText("0");
        ut_p.add(unassigned, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Unassigned Tickets");
        ut_p.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        jPanel2.add(ut_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 50));

        check.setBackground(new java.awt.Color(228, 57, 39));
        check.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        check.setForeground(new java.awt.Color(228, 57, 39));
        check.setText("Trash");
        jPanel2.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Ticketing ticket = new Ticketing();
        ticket.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void solvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solvedActionPerformed
        String t = check.getText();
        if(admin_table.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Select row to change status");
        }
        else{
        int row = admin_table.getSelectedRow();
        Object ID = admin_table.getModel().getValueAt(row, 0).toString();
        Object req = admin_table.getModel().getValueAt(row, 1).toString();
        Object email = admin_table.getModel().getValueAt(row, 2).toString();
        Object sub = admin_table.getModel().getValueAt(row, 3).toString();
        Object msg = admin_table.getModel().getValueAt(row, 4).toString();
        Object dep = admin_table.getModel().getValueAt(row, 5).toString();
        Object assign = admin_table.getModel().getValueAt(row, 6).toString();
        Object stats = admin_table.getModel().getValueAt(row, 7).toString();
        Object sent = admin_table.getModel().getValueAt(row, 8).toString();
        
        String from = null;
        String pass = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        String dt = formatter.format(date);
        try {
            pst = con.prepareStatement("SELECT * FROM tickets WHERE Assignee = ?");
            pst.setString(1, assign.toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                from = rs.getString("Assignee_Email");
                pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
                pst.setString(1, from);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pass = rs.getString("App_password");
                }
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        final String finalFrom = from;
        final String finalPass = pass;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.toString()));
            message.setSubject("Your request " + sub + " is Solved");
            message.setText(msg + "\n \n We just want you to know that your request is Solved ");
            Transport.send(message);
            
            pst=con.prepareStatement("Update tickets set status='Solved',status_change =? where ticket_ID = ?");
            pst.setString(1,dt);
            pst.setString(2,ID.toString());
            int update = pst.executeUpdate();
            if(update == 1){
                 JOptionPane.showMessageDialog(null, "Your message sent successfully");if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
            }
            
            
        } catch (Exception ex) {
            // Handle the exception properly, e.g., logging or printing the error
            ex.printStackTrace();
        }
         
        }
    }//GEN-LAST:event_solvedActionPerformed

    private void on_holdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_holdActionPerformed
        String t = check.getText();
        if(admin_table.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Select row to change status");
        }
        else{
        int row = admin_table.getSelectedRow();
        Object ID = admin_table.getModel().getValueAt(row, 0).toString();
        Object req = admin_table.getModel().getValueAt(row, 1).toString();
        Object email = admin_table.getModel().getValueAt(row, 2).toString();
        Object sub = admin_table.getModel().getValueAt(row, 3).toString();
        Object msg = admin_table.getModel().getValueAt(row, 4).toString();
        Object dep = admin_table.getModel().getValueAt(row, 5).toString();
        Object assign = admin_table.getModel().getValueAt(row, 6).toString();
        Object stats = admin_table.getModel().getValueAt(row, 7).toString();
        Object sent = admin_table.getModel().getValueAt(row, 8).toString();
        
        String from = null;
        String pass = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        String dt = formatter.format(date);
        try {
            pst = con.prepareStatement("SELECT * FROM tickets WHERE Assignee = ?");
            pst.setString(1, assign.toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                from = rs.getString("Assignee_Email");
                pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
                pst.setString(1, from);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pass = rs.getString("App_password");
                }
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        final String finalFrom = from;
        final String finalPass = pass;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.toString()));
            message.setSubject("Your request " + sub + " is On Hold");
            message.setText(msg + "\n \n We just want you to know that your request is On Hold ");
            Transport.send(message);
            
            pst=con.prepareStatement("Update tickets set status='On Hold',status_change =? where ticket_ID = ?");
            pst.setString(1,dt);
            pst.setString(2,ID.toString());
            int update = pst.executeUpdate();
            if(update == 1){
                 JOptionPane.showMessageDialog(null, "Your message sent successfully");if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
            }
            
            
        } catch (Exception ex) {
            // Handle the exception properly, e.g., logging or printing the error
            ex.printStackTrace();
        }
         
        }
    }//GEN-LAST:event_on_holdActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        String t = check.getText();
        if(admin_table.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Select row to change status");
        }
        else{
        int row = admin_table.getSelectedRow();
        Object ID = admin_table.getModel().getValueAt(row, 0).toString();
        Object req = admin_table.getModel().getValueAt(row, 1).toString();
        Object email = admin_table.getModel().getValueAt(row, 2).toString();
        Object sub = admin_table.getModel().getValueAt(row, 3).toString();
        Object msg = admin_table.getModel().getValueAt(row, 4).toString();
        Object dep = admin_table.getModel().getValueAt(row, 5).toString();
        Object assign = admin_table.getModel().getValueAt(row, 6).toString();
        Object stats = admin_table.getModel().getValueAt(row, 7).toString();
        Object sent = admin_table.getModel().getValueAt(row, 8).toString();
        
        String from = null;
        String pass = null;
        String change = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        String dt = formatter.format(date);
        
        try {
            String a = Ticketing.user.getText();
            pst = con.prepareStatement("SELECT * FROM users WHERE user_name= ?");
            pst.setString(1, a);
            rs = pst.executeQuery();
            if (rs.next()) {
                change = rs.getString("first_name" + "last_name");
                
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        
        try {
            pst = con.prepareStatement("SELECT * FROM tickets WHERE Assignee = ?");
            pst.setString(1, assign.toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                from = rs.getString("Assignee_Email");
                pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
                pst.setString(1, from);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pass = rs.getString("App_password");
                }
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        
        
        final String finalFrom = from;
        final String finalPass = pass;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.toString()));
            message.setSubject("Your request " + sub + " is Open");
            message.setText(msg + "\n \n We just want you to know that your request is Open ");
            Transport.send(message);
            
            pst=con.prepareStatement("Update tickets set status='Open',status_change =? where ticket_ID = ?");
            pst.setString(1,dt);
            pst.setString(2,ID.toString());
       
            int update = pst.executeUpdate();
            if(update == 1){
                 JOptionPane.showMessageDialog(null, "Your message sent successfully");if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
            }
            
           
            
            
            
        } catch (Exception ex) {
            // Handle the exception properly, e.g., logging or printing the error
            ex.printStackTrace();
        }
         
        }
        
    }//GEN-LAST:event_openActionPerformed

    private void pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingActionPerformed
        String t = check.getText();
        if(admin_table.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Select row to change status");
        }
        else{
        int row = admin_table.getSelectedRow();
        Object ID = admin_table.getModel().getValueAt(row, 0).toString();
        Object req = admin_table.getModel().getValueAt(row, 1).toString();
        Object email = admin_table.getModel().getValueAt(row, 2).toString();
        Object sub = admin_table.getModel().getValueAt(row, 3).toString();
        Object msg = admin_table.getModel().getValueAt(row, 4).toString();
        Object dep = admin_table.getModel().getValueAt(row, 5).toString();
        Object assign = admin_table.getModel().getValueAt(row, 6).toString();
        Object stats = admin_table.getModel().getValueAt(row, 7).toString();
        Object sent = admin_table.getModel().getValueAt(row, 8).toString();
        
        String from = null;
        String pass = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        String dt = formatter.format(date);
        try {
            pst = con.prepareStatement("SELECT * FROM tickets WHERE Assignee = ?");
            pst.setString(1, assign.toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                from = rs.getString("Assignee_Email");
                pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
                pst.setString(1, from);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pass = rs.getString("App_password");
                }
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        final String finalFrom = from;
        final String finalPass = pass;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.toString()));
            message.setSubject("Your request " + sub + " is Pending");
            message.setText(msg + "\n \n We just want you to know that your request is Pending ");
            Transport.send(message);
            
            pst=con.prepareStatement("Update tickets set status='Pending',status_change =? where ticket_ID = ?");
            pst.setString(1,dt);
            pst.setString(2,ID.toString());
            int update = pst.executeUpdate();
            if(update == 1){
                 JOptionPane.showMessageDialog(null, "Your message sent successfully");if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
            }
            
            
        } catch (Exception ex) {
            // Handle the exception properly, e.g., logging or printing the error
            ex.printStackTrace();
        }
         
        }
    }//GEN-LAST:event_pendingActionPerformed

    private void admin_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_tableMouseClicked
     
        
    }//GEN-LAST:event_admin_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) admin_table.getModel();
        int rowcount = model.getRowCount();
        if (rowcount == 0) {
            JOptionPane.showMessageDialog(null, "There's no request to view.");
        } else {
        if (admin_table.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select row to view");
        } else {
            int row = admin_table.getSelectedRow();
            Object ID = admin_table.getModel().getValueAt(row, 0).toString();
            Object req = admin_table.getModel().getValueAt(row, 1).toString();
            Object email = admin_table.getModel().getValueAt(row, 2).toString();
            Object sub = admin_table.getModel().getValueAt(row, 3).toString();
            Object msg = admin_table.getModel().getValueAt(row, 4).toString();
            Object dep = admin_table.getModel().getValueAt(row, 5).toString();
            Object assign = admin_table.getModel().getValueAt(row, 6).toString();
            Object stats = admin_table.getModel().getValueAt(row, 7).toString();
            Object sent = admin_table.getModel().getValueAt(row, 8).toString();

           
            View v = new View();
            v.setVisible(true);

            View.ID.setText("" + ID);
            View.requester.setText("" + req);
            View.email.setText("" + email);
            View.subject.setText("" + sub);
            View.msg.setText("" + msg);
            View.department.setSelectedItem(dep);
            View.access.setSelectedItem(assign);
            View.stats.setText("" + stats);
            View.date.setText("" + sent);
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void closedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closedActionPerformed
        String t = check.getName();
        if(admin_table.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Select row to change status");
        }
        else{
        int row = admin_table.getSelectedRow();
        Object ID = admin_table.getModel().getValueAt(row, 0).toString();
        Object req = admin_table.getModel().getValueAt(row, 1).toString();
        Object email = admin_table.getModel().getValueAt(row, 2).toString();
        Object sub = admin_table.getModel().getValueAt(row, 3).toString();
        Object msg = admin_table.getModel().getValueAt(row, 4).toString();
        Object dep = admin_table.getModel().getValueAt(row, 5).toString();
        Object assign = admin_table.getModel().getValueAt(row, 6).toString();
        Object stats = admin_table.getModel().getValueAt(row, 7).toString();
        Object sent = admin_table.getModel().getValueAt(row, 8).toString();
        
        String from = null;
        String pass = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        String dt = formatter.format(date);
        try {
            pst = con.prepareStatement("SELECT * FROM tickets WHERE Assignee = ?");
            pst.setString(1, assign.toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                from = rs.getString("Assignee_Email");
                pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
                pst.setString(1, from);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pass = rs.getString("App_password");
                }
            }
        } catch (SQLException ex) {
            // Handle the SQLException properly, e.g., logging or printing the error
        }
        final String finalFrom = from;
        final String finalPass = pass;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.toString()));
            message.setSubject("Your request " + sub + " is Closed");
            message.setText(msg + "\n \n We just want you to know that your request is Closed ");
            Transport.send(message);
            
            pst=con.prepareStatement("Update tickets set status='Closed',status_change =? where ticket_ID = ?");
            pst.setString(1,dt);
            pst.setString(2,ID.toString());
            int update = pst.executeUpdate();
            if(update == 1){
                 JOptionPane.showMessageDialog(null, "Your message sent successfully");if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
            }
            
            
        } catch (Exception ex) {
            // Handle the exception properly, e.g., logging or printing the error
            ex.printStackTrace();
        }
         
        }
    }//GEN-LAST:event_closedActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed
        
        if(un.equals("true")){
            Fetch_tickets1();
        }
        else{
            Fetch_tickets(); 
        }
       
        
    }//GEN-LAST:event_departmentActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        Fetch();
        un ="false";
        setColor(jPanel5);
        resetColor(ut_p);
        resetColor(jPanel9);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel11);
        check.setText("ass");
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
         delete.setEnabled(true);
         ret.setEnabled(false);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void ut_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ut_pMouseClicked
        unassigned();
        un = "true";
        setColor(ut_p);
        resetColor(jPanel9);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel11);
        check.setText("un");
        open.setEnabled(false);
        pending.setEnabled(false);
        solved.setEnabled(false);
        on_hold.setEnabled(false);
        closed.setEnabled(false);
        delete.setEnabled(false);
        ret.setEnabled(false);
    }//GEN-LAST:event_ut_pMouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        un = "false";
        check.setText("op");
        setColor(jPanel7);
        resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel9);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel11);
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
        ret.setEnabled(false);
        open();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        pending();
        un ="false";
        check.setText("pen");
        setColor(jPanel4);
        resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel9);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel11);
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
       hold();
       un ="false";
       check.setText("hold");
       setColor(jPanel8);
       resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel9);
        resetColor(jPanel10);
        resetColor(jPanel11);
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
        ret.setEnabled(false);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
       solved();
       un ="false";
       setColor(jPanel10);
       resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel9);
        resetColor(jPanel11);
       check.setText("sol");
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
        ret.setEnabled(false);
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
       closed();
       un ="false";
       check.setText("cl");
       setColor(jPanel11);
       resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel9);
        open.setEnabled(true);
        pending.setEnabled(true);
        solved.setEnabled(true);
        on_hold.setEnabled(true);
        closed.setEnabled(true);
        ret.setEnabled(false);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void retActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retActionPerformed
        DefaultTableModel model = (DefaultTableModel) admin_table.getModel();
        int rowcount = model.getRowCount();
        if(rowcount == 0){
             JOptionPane.showMessageDialog(null, "There's no request to retrieve.");
        }
        else{
        if (admin_table.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select row to change status.");
        } else {
            int row = admin_table.getSelectedRow();
            Object ID = admin_table.getModel().getValueAt(row, 0).toString();
            try {
                pst = con.prepareStatement("Insert into tickets select * from delete_tickets where ticket_id=?");
                pst.setString(1, ID.toString());
                int saved = pst.executeUpdate();
                if (saved == 1) {
                    pst = con.prepareStatement("Delete from delete_tickets where ticket_id=?");
                    pst.setString(1, ID.toString());
                    int s = pst.executeUpdate();
                    if (s == 1) {
                        pst = con.prepareStatement("Update tickets set status='Open' where ticket_id=? ");
                        pst.setString(1, ID.toString());
                        int retrieve = pst.executeUpdate();
                        if (retrieve == 1) {
                            JOptionPane.showMessageDialog(this, "You sucessfully retrieve this requests");
                            removed();
                            count();
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Can't retrieve this requests");
                }
            } catch (SQLException ex) {

            }
        }
        }
    }//GEN-LAST:event_retActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) admin_table.getModel();
        int rowcount = model.getRowCount();
        if(rowcount == 0){
             JOptionPane.showMessageDialog(null, "There's no request to delete.");
        }
        else{
        
        
        if (admin_table.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select row to change status");
        } else {
            int row = admin_table.getSelectedRow();
            Object ID = admin_table.getModel().getValueAt(row, 0).toString();
            String t = check.getText();
            if (t.equals("trash")) {
                int result = JOptionPane.showConfirmDialog(null, "Sure? You want to permanently delete this request?", "Delete Permanently",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        pst = con.prepareStatement("Delete from delete_tickets where ticket_id = ?");
                        pst.setString(1, ID.toString());
                        int del = pst.executeUpdate();
                        if (del == 1) {
                            JOptionPane.showMessageDialog(this, "You permanently delete this request");
                            removed();
                            count();
                        }
                    } catch (SQLException ex) {
                    }
                } else {
                    removed();
                            count();
                }

            } else if (!t.equals("trash")) {
                try {
                    pst = con.prepareStatement("Insert into delete_tickets select * from tickets where ticket_id = ?");
                    pst.setString(1, ID.toString());
                    int saved = pst.executeUpdate();
                    if (saved == 1) {
                        pst = con.prepareStatement("delete from tickets where ticket_id = ?");
                        pst.setString(1, ID.toString());
                        int save = pst.executeUpdate();
                        if (save == 1) {
                            pst = con.prepareStatement("Update delete_tickets set status='Removed' where ticket_id=?");
                            pst.setString(1, ID.toString());
                            int s = pst.executeUpdate();
                            if (s == 1) {
                                JOptionPane.showMessageDialog(this, "Delete request.");
                                if(t.equals("op")){
                                    open();
                                    count();
                                }
                                else if(t.equals("pen")){
                                    pending();
                                    count();
                                }
                                else if(t.equals("hold")){
                                    hold();
                                    count();
                                }
                                else if(t.equals("sol")){
                                    solved();
                                    count();
                                }
                                else if(t.equals("cl")){
                                    closed();
                                    count();
                                }
                                else if(t.equals("ass")){
                                    Fetch();
                                    count();
                                }
                            }

                        }

                    }

                } catch (SQLException ex) {

                }

            }
        }

        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        removed();
        un = "true";
        setColor(jPanel9);
        resetColor(ut_p);
        resetColor(jPanel5);
        resetColor(jPanel7);
        resetColor(jPanel4);
        resetColor(jPanel8);
        resetColor(jPanel10);
        resetColor(jPanel11);
        check.setText("trash");
        open.setEnabled(false);
        pending.setEnabled(false);
        solved.setEnabled(false);
        on_hold.setEnabled(false);
        closed.setEnabled(false);
        ret.setEnabled(true);
    }//GEN-LAST:event_jPanel9MouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admin_table;
    private javax.swing.JLabel assigned;
    private javax.swing.JLabel check;
    private javax.swing.JButton closed;
    private javax.swing.JLabel closed_label;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JLabel hold_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton on_hold;
    private javax.swing.JButton open;
    private javax.swing.JLabel open_label;
    private javax.swing.JButton pending;
    private javax.swing.JLabel pending_label;
    private javax.swing.JButton ret;
    private javax.swing.JButton solved;
    private javax.swing.JLabel solved_label;
    private javax.swing.JLabel trash;
    private javax.swing.JLabel unassigned;
    private javax.swing.JPanel ut_p;
    // End of variables declaration//GEN-END:variables
}
