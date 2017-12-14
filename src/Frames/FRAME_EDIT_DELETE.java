/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import static Frames.MainWindow.jLabel_god;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static logic.ModelEditor.myModel;
import logic.conn;
import static logic.conn.list;
import static logic.conn.listK;
import static logic.conn.listModel;
import static logic.conn.listModelK;
import static logic.conn.list_flag;
import static logic.conn.list_id_komp;
import static logic.conn.list_id_sad;
import static logic.mainlogic.init_db;

/**
 *
 * @author Силантьев Олег
 */
public class FRAME_EDIT_DELETE extends javax.swing.JFrame {
    /**
     * Creates new form FRAME_EDIT_DELETE
     */
     progress_bar pr_b = new progress_bar();
     public static boolean flag_del = false; 
    public FRAME_EDIT_DELETE() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {
         
        initComponents();
        get_table();
       if (!pr_b.isAlive())
        pr_b.start();

    }

     @Override
       public void dispose()
       {
         try {
             conn.CloseDB();
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
         }
         MainWindow.jCheckBoxMenuItem1.setState(false);
         jLabel_god.setVisible(false);
    MainWindow.jMenuItem2.setEnabled(true);
    MainWindow.jMenuItem4.setEnabled(true);
         super.dispose();  
       }

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        combobox_edit = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_edit = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Редактор базы");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        combobox_edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        combobox_edit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Учреждение", "Компьютеры" }));
        combobox_edit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_editItemStateChanged(evt);
            }
        });
        combobox_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_editActionPerformed(evt);
            }
        });
        combobox_edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_editKeyPressed(evt);
            }
        });

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jTable1_edit.setAutoCreateRowSorter(true);
        jTable1_edit.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTable1_edit.setModel(myModel);
        jTable1_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1_edit.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_editMouseClicked(evt);
            }
        });
        jTable1_edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1_editKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_edit);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Удалить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 0));
        jButton3.setText("Добавить компьютер");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setText("Редактировать");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 102));
        jButton5.setText("Добавить учреждение");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jProgressBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox_edit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combobox_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_editActionPerformed
   
    }//GEN-LAST:event_combobox_editActionPerformed

    private void combobox_editItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_editItemStateChanged
disable_enable();
        try {
            get_table();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
             Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_combobox_editItemStateChanged

    void disable_enable()
    {
        if (jTable1_edit.getSelectedRow()>=0)
        {
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
        }
        else 
        {
             jButton2.setEnabled(false);
            jButton4.setEnabled(false);
        }
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     flag_del = true;
        delete_sad del1 = new delete_sad();
       delete_komp del_k = new delete_komp();
       Image image = Toolkit.getDefaultToolkit().createImage(del1.getClass().getResource("/res/icon.png") );
        del1.setIconImage( image );
      Image image1 = Toolkit.getDefaultToolkit().createImage( del_k.getClass().getResource("/res/icon.png") );
        del_k.setIconImage( image1 );
        del1.setLocationRelativeTo(null);
        del_k.setLocationRelativeTo(null);
        if (combobox_edit.getSelectedIndex()==0)
          del1.setVisible(true);
        else del_k.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed
add_sad add_s = new add_sad();
add_KOMPS add_k = new add_KOMPS();
edit_komps_uch edit = new edit_komps_uch();
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Image image = Toolkit.getDefaultToolkit().createImage( add_s.getClass().getResource("/res/icon.png") );
        add_s.setIconImage( image );
        add_s.setLocationRelativeTo(null);
        add_s.setVisible(true);
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Image image = Toolkit.getDefaultToolkit().createImage( add_k.getClass().getResource("/res/icon.png") );
        add_k.setIconImage( image );
        add_k.setLocationRelativeTo(null);
        add_k.setVisible(true);
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Image image = Toolkit.getDefaultToolkit().createImage( add_k.getClass().getResource("/res/icon.png") );
        edit.setIconImage( image );
        edit.setLocationRelativeTo(null);
        edit.get_komps_or_uch();
        edit.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1_editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1_editKeyPressed
        disable_enable();
          if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            dispose();
        }
    }//GEN-LAST:event_jTable1_editKeyPressed

    private void jTable1_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_editMouseClicked
       disable_enable();
    }//GEN-LAST:event_jTable1_editMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            dispose();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            dispose();
        }
    }//GEN-LAST:event_formKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         try {
             conn.CloseDB();
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_formWindowClosing

    private void combobox_editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_editKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            dispose();
        }
    }//GEN-LAST:event_combobox_editKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            setState(JFrame.ICONIFIED);
        }
    }//GEN-LAST:event_jScrollPane1KeyPressed

    public class progress_bar extends Thread
    {
        public void run()
        {
            while (0<1)
            {
                if ((add_s.isVisible()) || (add_k.isVisible()) || (flag_del==true))
                    jProgressBar1.setIndeterminate(true);
                else 
                    jProgressBar1.setIndeterminate(false);
                try {
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
                }

         }
        }
    }
    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FRAME_EDIT_DELETE().setVisible(true);
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FRAME_EDIT_DELETE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }

    
    
    
    
    
    public static void get_table() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException
    {
        
        conn.CloseDB();
        init_db();
        try {
            conn.Conn();
		conn.CreateDB();
		//conn.WriteDB();
		conn.ReadDB();
        } catch ( ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        myModel.setRowCount(0);
        if (combobox_edit.getSelectedIndex()==0)
                for (int i=0;i<list_id_sad.size();i++)
                {
                   myModel.addRow(new Object[0]);
                   myModel.setValueAt(list_id_sad.get(i), i, 0);
                   myModel.setValueAt(listModel.get(i), i, 1);
                   myModel.setValueAt(list.get(i), i, 3);
                }
        System.out.println("Вон их сколько: " + list_id_komp.size());
        if (combobox_edit.getSelectedIndex()==1)
            for (int i=0;i<list_id_komp.size();i++)
                {
            myModel.addRow(new Object[0]);
            myModel.setValueAt(list_id_komp.get(i), i, 0);
            try {
            myModel.setValueAt(listModelK.get(i), i, 1);
            } catch (Exception e)  {myModel.setValueAt("NULLEXCEPTION", i, 1);}
            try { 
            myModel.setValueAt(listK.get(i), i, 2);
            } catch (Exception e) {myModel.setValueAt("NULLEXCEPTION", i, 2);}
            try {
            myModel.setValueAt(list_flag.get(i), i, 3);
            } catch (Exception e) {myModel.setValueAt("NULLEXCEPTION", i, 3);}
                }
        System.out.println("Вон их сколько: " + list_id_komp.size());
       myModel.fireTableDataChanged();
   //    jTable1.setModel(myModel);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> combobox_edit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1_edit;
    // End of variables declaration//GEN-END:variables
}