/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_mange_result;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rushi
 */
public class StudentHome extends javax.swing.JFrame {

    /**
     * Creates new form StudentHome
     */
    public StudentHome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Student Result's Section");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 360, 70));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Roll number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 170, 30));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_mange_result/icons8-schoolboy-at-a-desk-30.png"))); // NOI18N
        jButton1.setText("Show Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 200, -1));

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_mange_result/icons8-cancel-24.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 140, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_mange_result/school_pic1.jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //show result button
        
        String rollno=jTextField1.getText();
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/rushi","root","1234");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student inner join result where student.rollno='"+rollno+"' and result.rollno='"+rollno+"'");
            if(rs.next()){
                setVisible(false);
                new StudentResult(rollno).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This roll number doesn't exist.");
            }
        }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //back button
        
         setVisible(false);
                new FirstPage().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}