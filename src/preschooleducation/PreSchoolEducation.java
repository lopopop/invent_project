/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preschooleducation;

import Frames.MainWindow;
import Frames.welcome;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileLock;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import logic.conn;

/**
 *
 * @author Силантьев Олег
 */
public class PreSchoolEducation {

    /**
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
 
  public static boolean ready_to_start = false;
    public static welcome welc = new welcome();
    public static final String ICON_STR = "/res/icon_LARGE.png";
     private static final  SystemTray systemTray = SystemTray.getSystemTray();
     private static final URL imageURL = PreSchoolEducation.class.getResource(ICON_STR);
    private static final Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
    public static boolean flag_tray = true;
    private static final TrayIcon trayIcon = new TrayIcon(icon, "Дошкольное образование");
    
    
 
    
    
    
      private static void removeTrayIcon()
  {
    systemTray.remove(trayIcon);
  }
 
  public static void addTrayIcon()
  {
    try
    {
      systemTray.add(trayIcon);
      if (flag_tray)
     // trayIcon.displayMessage("Управление компьютерами", "Теперь при сворачивании окна иконка находится в трее.", TrayIcon.MessageType.INFO);
      flag_tray=false;
    }
    catch(AWTException ex)
    {
    }
  }
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, AWTException, Throwable {
         
        logic.OneInstance.singleAppInstanceCheck();
        conn.open_and_save_config();
       Image image = Toolkit.getDefaultToolkit().createImage( welc.getClass().getResource("/res/icon_LARGE.png") );
       welc.setIconImage( image );
       welc.setVisible(true);
       welc.setLocationRelativeTo(null);
        try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) { }
        if ( logic.mainlogic.init_db())
       {
        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
         
          
        
          try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) { }
            welc.dispose();
        MainWindow frame = new MainWindow();
        frame.setLocationRelativeTo(null);
        WindowListener exitListener = new WindowAdapter() {

            
            
            
            
            
    @Override
    public void windowClosing(WindowEvent e) {
            try {
                conn.CloseDB();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PreSchoolEducation.class.getName()).log(Level.SEVERE, null, ex);
            }
           System.exit(0);
    }
};
        

    
    

    URL imageURL = PreSchoolEducation.class.getResource(ICON_STR);

    
    trayIcon.setImageAutoSize(true);

    SystemTray tray = SystemTray.getSystemTray();
    try {
      tray.add(trayIcon);
    } catch (AWTException e) {
    }

  //  trayIcon.displayMessage("Управление компьютерами РЦДО", "Теперь доступно в системном трее!",
 //                           TrayIcon.MessageType.INFO);
        trayIcon.addActionListener((ActionEvent e) -> {
            frame.setVisible(true);
            frame.setState(JFrame.NORMAL);
            removeTrayIcon();
        });
  
        trayIcon.addMouseListener(new MouseListener()
        {
          

            @Override
            public void mouseReleased(MouseEvent e) {
                 frame.setVisible(true);
        frame.setState(JFrame.NORMAL);
        removeTrayIcon();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                 frame.setVisible(true);
        frame.setState(JFrame.NORMAL);
        removeTrayIcon();
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 frame.setVisible(true);
        frame.setState(JFrame.NORMAL);
        removeTrayIcon();
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 frame.setVisible(true);
        frame.setState(JFrame.NORMAL);
        removeTrayIcon();
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 frame.setVisible(true);
        frame.setState(JFrame.NORMAL);
        removeTrayIcon();
              
            }

            
        });
          
    frame.addWindowStateListener((WindowEvent e) -> {
        if(e.getNewState() == JFrame.ICONIFIED)
        {
            frame.setVisible(false);
            addTrayIcon();
        }
        });
  
        removeTrayIcon();
        frame.addWindowListener(exitListener);
   
        frame.setIconImage( image );
        frame.setVisible(true);
      //  trayIcon = new TrayIcon(image_tray, "Tray Demo");
        // TODO code application logic here

       }
    }
    
}
