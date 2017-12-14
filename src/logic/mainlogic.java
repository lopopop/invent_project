/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import Frames.MainWindow;
import static Frames.MainWindow.jLabel_god;
import java.awt.Color;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;


/**
 *
 * @author Силантьев Олег
 */

public class mainlogic {
  	public static boolean init_db() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {
            
		conn.Conn();
		conn.CreateDB();
                
		//conn.WriteDB();
		if (conn.ReadDB())
                {
                    conn.CloseDB();
                    try {
                        jLabel_god.setVisible(true);
                    MainWindow.jLabel_god.setForeground(Color.magenta);
                     MainWindow.jLabel_god.setText("БАЗА ДАННЫХ ОБНОВЛЕНА!");
                    } catch (Exception e) {}
                    return true;
                }
                
                
                    conn.CloseDB();
                    try {
                        jLabel_god.setVisible(true);
                    MainWindow.jLabel_god.setForeground(Color.magenta);
                     MainWindow.jLabel_god.setText("БАЗА ДАННЫХ ОБНОВЛЕНА!");
                    } catch (Exception e) {}
                    return false;
                   
	}
        

        
        public static boolean ping_some(String ips) throws UnknownHostException, IOException
        {
   
            final InetAddress host = InetAddress.getByName(ips); 
              return host.isReachable(1000);
             
        }
}
    

