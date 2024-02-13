
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mayuri
 */
public class Channel extends javax.swing.JFrame {

    /**
     * Creates new form Channel
     */

    public Channel() {
        initComponents();
         Connect();
        AutoID();
        LoadDoctor();
        LoadPatient();
         Channel_table();
       
        
     
       
       
    }

String chno;
public class Doctor
{
    String id;
    String name;
    
    
    public Doctor(String id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public String toString()
    {
        return name;
}
}





    public class Patient
{
    String id;
    String name;
    
    
    public Patient(String id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public String toString()
    {
        return name;
}
    }   
    
    
    
    public void LoadPatient()
    {
         try {
                            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
                            String query = "select *from patient";
            
                            PreparedStatement preparedStmt = connection.prepareStatement(query);
                           ResultSet rs = preparedStmt.executeQuery();
                            jComboBox2.removeAll();
                           while (rs.next())
                           {
                                jComboBox2.addItem(new Patient( rs.getString(1)  , rs.getString(2) ));
                           }
          
            
            
                            preparedStmt.executeUpdate();
            
                          
            
            
                                  
            
                            connection.close();
                            System.out.println("connected database successfully...");
                        } catch (SQLException e1) {
                            System.out.println(e1);
                        }
    }

   

    public void LoadDoctor()
    {
         try {
                            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
                            String query = "select *from Doctor";
            
                            PreparedStatement preparedStmt = connection.prepareStatement(query);
                           ResultSet rs = preparedStmt.executeQuery();
                            jComboBox1.removeAll();
                           while (rs.next())
                           {
                                jComboBox1.addItem(new Doctor( rs.getString(1)  , rs.getString(2) ));
                           }
          
            
            
                            preparedStmt.executeUpdate();
            
                          
            
            
                                  
            
                            connection.close();
                            System.out.println("connected database successfully...");
                        } catch (SQLException e1) {
                            System.out.println(e1);
                        }
    }


//public  void LoadDoctor()
//    {
//        try {
//
//           Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
//                            String query = "select *from Doctor";
//            
//                            PreparedStatement preparedStmt = connection.prepareStatement(query);
//                           ResultSet rs = preparedStmt.executeQuery();
//                            jComboBox1.removeAll();
//                           while (rs.next())
//                           {
//                                jComboBox1.addItem(new Doctor( rs.getString(1)  , rs.getString(2) ));
//                           }
//          
//            
//            
//                            preparedStmt.executeUpdate();
//            
//                          
//            
//        
//                                  
//            
//                            connection.close();
//                            System.out.println("connected database successfully...");
//
//        } catch (SQLException e) {
//            System.out.println("Error while connecting database");
//        }
//    }
//}
//
//

    public  void Connect()
    {
        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");

            System.out.println("Connected with the database sucessfully");

        } catch (SQLException e) {
            System.out.println("Error while connecting database");
        }
    }
    
     public void AutoID()
    {
        try{
             Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("select MAX(channelno)from channel");
           rs.next();
            rs.getString("MAX(channelno)");
           if(rs.getString("MAX(channelno)")==null)
           {
               lbchno.setText("CH001");
           }
else
           {
                long id= Long.parseLong
                      (rs.getString("MAX(channelno)").substring(2,rs.getString("MAX(channelno)").length()));
                 id++;
               
            lbchno.setText("CH"+String.format("%03d", id));
           }
            connection.close();
            System.out.println("Connected database successfully");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }



public void Channel_table()
{
    try{
     Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
PreparedStatement stmt = connection.prepareStatement("select *from channel");

           // Statement stmt = connection.createStatement();
          
           ResultSet rs = stmt.executeQuery("select * from  channel");
           ResultSetMetaData rsm = rs.getMetaData();
           int c;
           c=rsm.getColumnCount();
           
           DefaultTableModel df =(DefaultTableModel)jTable1.getModel();
           df.setRowCount(0);
           while(rs.next())
           {
               Vector v2 = new Vector();
               
               for(int i=1;i<=c;i++)
               {
               v2.add(rs.getString("channelno"));
                 v2.add(rs.getString("doctorname"));
                   v2.add(rs.getString("patientname"));
                     v2.add(rs.getString("roomno"));
                       v2.add(rs.getString("date"));
                       
               
           }
               df.addRow(v2);
           }
           
    }   catch (SQLException e) {
            System.out.println(e);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbchno = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Channel Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(51, 0, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Channel No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Doctor Name:-");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Patient Name:-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Room No.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Channel Date");

        lbchno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbchno.setForeground(new java.awt.Color(0, 0, 204));
        lbchno.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbchno, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, 0, 170, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbchno))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Channel No.", "Doctor  Name", "Patient Name", "Room No", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("CHANNEL");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(351, 351, 351))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String chno =lbchno.getText();
         Doctor d =(Doctor) jComboBox1.getSelectedItem();
         Patient p = (Patient) jComboBox2.getSelectedItem();
         String room =jSpinner1.getValue().toString();
         
         
         SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
         String date = dateformat.format(jDateChooser1.getDate());
         
         
        
        
         try {
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
                String query = "insert  into channel(channelno,doctorname,patientname,roomno,date)"
                        + "values(?,?,?,?,?)";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, chno);
                preparedStmt.setString(2, d.id);
                preparedStmt.setString(3, p.id);
                preparedStmt.setString(4, room);
                 preparedStmt.setString(5, date);
                

                preparedStmt.executeUpdate();
                
               
                 JOptionPane.showMessageDialog(this,"Channel Created !");
                AutoID();
               lbchno.setText("");
                       jComboBox1.setSelectedIndex(-1);
                       jComboBox2.setSelectedIndex(-1);
                       jSpinner1.setValue(0);
                       
                 Channel_table();
                connection.close();
                System.out.println("connected database successfully...");
            } catch (SQLException e1) {
                System.out.println(e1);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          DefaultTableModel dl = (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        
         chno =(dl.getValueAt(SelectIndex,0).toString());
     // JOptionPane.showMessageDialog(this,chno);
          
          //jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
         
        
        
         try {
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "");
                String query = "delete from channel where channelno =?";
                       

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, chno);
               
                

                preparedStmt.executeUpdate();
                
               
                 JOptionPane.showMessageDialog(this,"Channel Deleted !");
                AutoID();
               lbchno.setText("");
                       jComboBox1.setSelectedIndex(-1);
                       jComboBox2.setSelectedIndex(-1);
                       jSpinner1.setValue(0);
                       
                 Channel_table();
                connection.close();
                System.out.println("connected database successfully...");
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Channel().setVisible(true);
            }
        });
        new Channel();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbchno;
    // End of variables declaration//GEN-END:variables
}
