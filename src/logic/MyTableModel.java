/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class MyTableModel {
    
public static DefaultTableModel model = new DefaultTableModel(null,new String []{"Описание", "Имя компьютера", "Состояние"})
{
    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 2: return ImageIcon.class;
            default: return String.class;
        }
    }
    
 
 

     @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
};


public  void init_tables() {
    
   // model.setColumnIdentifiers("Состояние","Имя компьютера","Описание");
} 


}

