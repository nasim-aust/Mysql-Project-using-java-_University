package db_assignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nasim
 */

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class database_info extends javax.swing.JFrame {
    
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public static String s;

    /**
     * Creates new form database_info
     */
    public database_info() {
        initComponents();
        connection = MyDatabaseHandler.setConnection();
        Update_table();
        //show();
    }
    
    
    void Update_table(){
        
        try{
        String sql = "select * from student";
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        Table_University.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    //show the all tables
    
    /*public void show (String value){
       try{
            String query = "SELECT * FROM "+value;
           
            Statement statement ;
            statement = connection.createStatement();
            rs = statement
                   .executeQuery(query);
  if(value.equals("student")){
            ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);

           
            while(rs.next()){
 
                String id = rs.getString("id");
                String name = rs.getString("name");
                String dept_name = rs.getString("dept_name");
                String total_cred = rs.getString("tot_cred");
           
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
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String s_id = rs.getString("s_id");
                String i_id = rs.getString("i_id");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(s_id);
                list.add(i_id);
                model.addRow(list.toArray());
                
            }
  }
  else if(value.equals("classroom")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next()){
                String building = rs.getString("building");
                String room_no = rs.getString("room_no");
                String capacity=rs.getString("capacity");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(building);
                list.add(room_no);
                list.add(capacity);
                model.addRow(list.toArray());
                
            }
  }
  else if(value.equals("department")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String dept_name = rs.getString("dept_name");
                String building = rs.getString("building");
                String budget=rs.getString("budget");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(dept_name);
                list.add(building);
                list.add(budget);
              
                model.addRow(list.toArray());
            }
  }
  else if(value.equals("instructor")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    System.out.println(value);
            while(rs.next()){
                String ID = rs.getString("ID");
                String name = rs.getString("name");
                String dept_name=rs.getString("dept_name");
                String salary=rs.getString("salary");
                
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
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String course_id = rs.getString("course_id");
                String prereq_id = rs.getString("prereq_id");
                
                ArrayList<String> list = new ArrayList<String>();
                list.add(course_id);
                list.add(prereq_id);
                
                model.addRow(list.toArray());
            }
  }
  else if (value.equals("section")){
             ArrayList<String>  columns = new ArrayList<String>();
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String course_id = rs.getString("course_id");
                String sec_id = rs.getString("sec_id");
                String semester=rs.getString("semester");
                String year=rs.getString("year");
                String building = rs.getString("building");
                String room_no = rs.getString("room_no");
                String time_slot_id=rs.getString("time_slot_id");
                
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
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next()){
                String id = rs.getString("id");
                String course_id = rs.getString("course_id");
                String sec_id=rs.getString("sec_id");
                String semester=rs.getString("semester");
                String year = rs.getString("year");
                String grade = rs.getString("grade");
                
                
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
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String id = rs.getString("id");
                String course_id = rs.getString("course_id");
                String sec_id=rs.getString("sec_id");
                String semester=rs.getString("semester");
                String year = rs.getString("year");
            
                
                
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
            for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i ++ ){
                System.out.println(rs.getMetaData().getColumnName(i));
                columns.add(rs.getMetaData().getColumnName(i));
            }
            //System.out.println(resultSet.getMetaData().getColumnCount());
            DefaultTableModel model = (DefaultTableModel)Table_University.getModel();
                    System.out.println(value);
            while(rs.next() ){
                String time_slot_id = rs.getString("time_slot_id");
                String day = rs.getString("day");
                String start_time=rs.getString("start_time");
                String end_time=rs.getString("end_time");
              
                
                
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
       
   }*/
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_University = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_dept_name = new javax.swing.JTextField();
        txt_tot_credit = new javax.swing.JTextField();
        ComboBox_name1 = new javax.swing.JComboBox<>();
        Cmd_save = new javax.swing.JButton();
        Cmd_delete = new javax.swing.JButton();
        Cmd_Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_University.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_University.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_UniversityMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_University);

        jLabel1.setText("ID");

        jLabel2.setText("name");

        jLabel3.setText("dept_name");

        jLabel4.setText("tot_credit");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        ComboBox_name1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00128", "123", "12345", "19991", "2", "23121", "44553", "456", "45678", "54321", "55739", "70557", "76543", "76653", "98765", "98988" }));
        ComboBox_name1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboBox_name1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        Cmd_save.setText("insert");
        Cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_saveActionPerformed(evt);
            }
        });

        Cmd_delete.setText("Delete");
        Cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_deleteActionPerformed(evt);
            }
        });

        Cmd_Update.setText("Update");
        Cmd_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_tot_credit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_name)
                                    .addComponent(txt_ID))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cmd_save, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cmd_delete, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cmd_Update, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ComboBox_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBox_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cmd_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cmd_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_dept_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cmd_Update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_tot_credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_UniversityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_UniversityMouseClicked
        // TODO add your handling code here:
        try{
            int row = Table_University.getSelectedRow();
            String table_click = (Table_University.getModel().getValueAt(row,0).toString());
            
            String sql = "select * from student where ID = "+table_click+" ";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("ID");
                txt_ID.setText(add1);
                
                String add2 = rs.getString("name");
                txt_name.setText(add2);
                
                String add3 = rs.getString("dept_name");
                txt_dept_name.setText(add3);
                
                String add4 = rs.getString("tot_cred");
                txt_tot_credit.setText(add4);
                
                //String add5 = rs.getString("s_id");
                //txt_s_id.setText(add5);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
            
            
        }
        Update_table();
        
        
    }//GEN-LAST:event_Table_UniversityMouseClicked

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void ComboBox_name1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBox_name1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        
        String tmp = (String)ComboBox_name1.getSelectedItem();
        String sql = "select * from student where ID = ?";
        
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                String add1 = rs.getString("ID");
                txt_ID.setText(add1);
                
                String add2 = rs.getString("name");
                txt_name.setText(add2);
                
                String add3 = rs.getString("dept_name");
                txt_dept_name.setText(add3);
                
                String add4 = rs.getString("tot_cred");
                txt_tot_credit.setText(add4);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        Update_table();
    }//GEN-LAST:event_ComboBox_name1PopupMenuWillBecomeInvisible

    private void Cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_saveActionPerformed
        // TODO add your handling code here:
        
        
        try{
            
            String query = "INSERT INTO student(ID,name,dept_name,tot_cred) VALUES(?,?,?,?)";
            
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, txt_ID.getText());
            pStatement.setString(2, txt_name.getText());
            pStatement.setString(3, txt_dept_name.getText());
            pStatement.setString(4, txt_tot_credit.getText());
           
            pStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Successfully inserted");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        Update_table();
    }//GEN-LAST:event_Cmd_saveActionPerformed

    private void Cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_deleteActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM student where ID =?";
        
        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, txt_ID.getText());
            
            
            pStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully deleted");
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        Update_table();
    }//GEN-LAST:event_Cmd_deleteActionPerformed

    private void Cmd_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_UpdateActionPerformed
        // TODO add your handling code here:
        
        
        try{
            String value1 = txt_ID.getText();
            String value2 = txt_name.getText();
            String value3 = txt_dept_name.getText();
            String value4 = txt_tot_credit.getText();
            
            String query = "UPDATE student set ID = ?, name = ?, dept_name = ?,tot_cred= ? where ID = ? ";
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, txt_ID.getText());
            pStatement.setString(2, txt_name.getText());
            pStatement.setString(3, txt_dept_name.getText());
            pStatement.setString(4, txt_tot_credit.getText());
            pStatement.setString(5, txt_ID.getText());
            
            System.out.println(query);
            pStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully updated");
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        Update_table();
        
    }//GEN-LAST:event_Cmd_UpdateActionPerformed

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
            java.util.logging.Logger.getLogger(database_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(database_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(database_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(database_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new database_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cmd_Update;
    private javax.swing.JButton Cmd_delete;
    private javax.swing.JButton Cmd_save;
    private javax.swing.JComboBox<String> ComboBox_name1;
    private javax.swing.JTable Table_University;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_dept_name;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_tot_credit;
    // End of variables declaration//GEN-END:variables
}
