
package db_assignment;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;

import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
public class MyDatabaseHandler extends javax.swing.JFrame {
    public MyDatabaseHandler() {
        initComponents();
    }
    Connection connect = null;
    ResultSet resultSet = null;
    PreparedStatement pStatement = null;
    public static String s;
   
    public static String arr[]=new String[10];  
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    public static Connection setConnection(){
        
        try{
            String dbName = "university_database_final";
            Class.forName("com.mysql.jdbc.Driver");
            //Connection connect = DriveManager.getConnection("jdbc:mysql://localhost/" + dbName);
            
            Connection connect = DriverManager.getConnection
                ("jdbc:mysql://localhost/university_database_final?"+ "user=root");
            
            System.out.println("Successfully Connected..");
            //testQuery();
            
            return connect;
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null , e);
            System.out.println("Connection Problem..");
            e.printStackTrace();
            return null;
        }
    }
   
   
   /*public void ChooseInsert (String value){
       if(value.equals("student")){
           StudentInsert SInsert=new StudentInsert(connect);
           SInsert.setVisible(true);
       }
       else if (value.equals("advisor")){ 
           AdvisorInsert AInsert=new AdvisorInsert(connect);
           AInsert.setVisible(true);
       }
   }*/
    String value;
   
    public void show (String value){
        try{
            String query = "SELECT * FROM "+value;
           
            Statement statement ;
            statement = connect.createStatement();
            resultSet = statement
                   .executeQuery(query);
    if(value.equals("student")){
            ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);

           
            while(resultSet.next()){
 
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String dept_name = resultSet.getString("dept_name");
                String total_cred = resultSet.getString("tot_cred");
           
                ArrayList<String> list = new ArrayList<String>();
                list.add(id);
                list.add(name);
                list.add(dept_name);
                list.add(total_cred);
            
                model.addRow(list.toArray());
                
            }
  } 
  else if( value.equals("advisor")){
            ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String s_id = resultSet.getString("s_id");
                String i_id = resultSet.getString("i_id");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(s_id);
                list.add(i_id);
                model.addRow(list.toArray());
                
            }
  }
  else if(value.equals("classroom")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next()){
                String building = resultSet.getString("building");
                String room_no = resultSet.getString("room_no");
                String capacity=resultSet.getString("capacity");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(building);
                list.add(room_no);
                list.add(capacity);
                model.addRow(list.toArray());
                
            }
  }
  else if(value.equals("department")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String dept_name = resultSet.getString("dept_name");
                String building = resultSet.getString("building");
                String budget=resultSet.getString("budget");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(dept_name);
                list.add(building);
                list.add(budget);
              
                model.addRow(list.toArray());
            }
  }
  else if(value.equals("instructor")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next()){
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String dept_name=resultSet.getString("dept_name");
                String salary=resultSet.getString("salary");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(ID);
                list.add(name);
                list.add(dept_name);
                list.add(salary);
                model.addRow(list.toArray());
            }
  }
  else if(value.equals("prereq")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String course_id = resultSet.getString("course_id");
                String prereq_id = resultSet.getString("prereq_id");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(course_id);
                list.add(prereq_id);
                
                model.addRow(list.toArray());
            }
  }
  else if (value.equals("section")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String course_id = resultSet.getString("course_id");
                String sec_id = resultSet.getString("sec_id");
                String semester=resultSet.getString("semester");
                String year=resultSet.getString("year");
                String building = resultSet.getString("building");
                String room_no = resultSet.getString("room_no");
                String time_slot_id=resultSet.getString("time_slot_id");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(course_id);
                list.add(sec_id);
                list.add(semester);
                list.add(year);
                list.add(building);
                list.add(room_no);
                list.add(time_slot_id);
                model.addRow(list.toArray());
            }
  }
  else if (value.equals("takes")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String course_id = resultSet.getString("course_id");
                String sec_id=resultSet.getString("sec_id");
                String semester=resultSet.getString("semester");
                String year = resultSet.getString("year");
                String grade = resultSet.getString("grade");
                
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(id);
                list.add(course_id);
                list.add(sec_id);
                list.add(semester);
                list.add(year);
                list.add(grade);
                
                model.addRow(list.toArray());
            }
  }
  else if (value.equals("teaches")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String id = resultSet.getString("id");
                String course_id = resultSet.getString("course_id");
                String sec_id=resultSet.getString("sec_id");
                String semester=resultSet.getString("semester");
                String year = resultSet.getString("year");
            
                
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(id);
                list.add(course_id);
                list.add(sec_id);
                list.add(semester);
                list.add(year);
              
                
                model.addRow(list.toArray());
            }
  }
  else if (value.equals("time_slot")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= resultSet.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(resultSet.next() ){
                String time_slot_id = resultSet.getString("time_slot_id");
                String day = resultSet.getString("day");
                String start_time=resultSet.getString("start_time");
                String end_time=resultSet.getString("end_time");
              
                
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(time_slot_id);
                list.add(day);
                list.add(start_time);
                list.add(end_time);
                model.addRow(list.toArray());
            }
            System.out.println("Successfully Done Query..");
  }
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
        }
       
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try{
            s=jTextField1.getText();
            System.out.println(s);

            Class.forName("com.mysql.jdbc.Driver");
            ;
            connect = DriverManager.getConnection
                ("jdbc:mysql://localhost/"+s+"?user=root");
           /* PreparedStatement pStatement = connect.prepareStatement(k);
            pStatement.setString(1, "b2");*/
            System.out.println("Successfully Connected to Mysql");
            
            
            
            

        }catch(Exception e){
            No_database fr=new No_database();
            fr.setVisible(true);
            System.out.println("Not Connected..");
            e.printStackTrace();
        }
           try{
            String query = "Show tables";
            String table_name;
            Statement statement ;
            statement = connect.createStatement();
            resultSet = statement
                   .executeQuery(query);
           DatabaseMetaData md = connect.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                table_name=rs.getString("TABLE_NAME");
                jComboBox1.addItem(table_name);
                
            }
            System.out.println("Successfully Done Query..");
          
        }catch(Exception e){
             No_database fr=new No_database();
            fr.setVisible(true);
            System.out.println("Not Connected..");
            System.out.println("Error in Query..");
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       String v = jComboBox1.getSelectedItem().toString();
        show(v);
        
        database_info s =  new database_info();
        s.setVisible(true);
        
        
        
        /*if(value.equals("student")){
            database_info s =  new database_info();
            s.setVisible(true);
        }
        else if(value.equals("advisor"))
        {
            advisor a = new advisor();
            a.setVisible(true);
        }*/
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
            java.util.logging.Logger.getLogger(MyDatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyDatabaseHandler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}