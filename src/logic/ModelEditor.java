/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Силантьев Олег
 */
public class ModelEditor {
    public static DefaultTableModel myModel = new DefaultTableModel(null,new String []{"ID", "Учреждение", "Компьютер","Описание"})
{
     @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
};
}
