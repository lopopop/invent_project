package logic;

import Frames.FRAME_UPDATE;
import Frames.MainWindow;
import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import static preschooleducation.PreSchoolEducation.welc;



public class conn {
        public static String VERSION_ = "1.2.0";
        public static String server_db = "\\\\server\\remote\\PSE_new_db.sdb";
        public static String server_old_db = "\\\\server\\remote\\OLD\\PSE_db_old_";
        public static boolean MYSQL_ON = false;
        private static String MYSQL_user = "1";
    private static String MYSQL_password = "1";
        
        
         
        public static String VERSION_DB;
      	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
        public static ResultSet resSet2;
        public static ResultSet resSet3;
        public static int n_sad=0;
        public static DefaultListModel listModel = new DefaultListModel();
        public static DefaultComboBoxModel comboModel = new DefaultComboBoxModel(); 
        public static ArrayList<String> list = new ArrayList<String>();
        public static ArrayList<Integer> list_id_sad = new ArrayList<Integer>();
        public static ArrayList<Integer> list_id_komp = new ArrayList<Integer>();
        
        
	
        public static DefaultListModel listModelK = new DefaultListModel();
        public static ArrayList<String> listK = new ArrayList<String>();
        public static ArrayList<String> list_flag = new ArrayList<String>();
        public static DefaultListModel  listK_new = new DefaultListModel();
        public static DefaultListModel list_tr = new DefaultListModel();
        
        
                  
        public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
if (!MYSQL_ON)    Files.copy(source.toPath(), dest.toPath());
}
        
        @SuppressWarnings("empty-statement")
       private static List<String> readFile(String filename) throws IOException
{
    String text;
        List<String> records = new ArrayList<>();
            try
            {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    records.add(line);
                }
            }
                return records;
            }
        catch (IOException e)
             {
                System.out.println("Ошибка во время чтения файла config.cfg '%s'.");
                File file = new File("config.cfg");
                  try {
        //проверяем, что если файл не существует то создаем его
        if(!file.exists()){
            file.createNewFile();
        }
            text = "\r\nPATH=" + server_db + "\r\nOLD=" + server_old_db + "\r\n";
        try (       //PrintWriter обеспечит возможности записи в файл
                PrintWriter out = new PrintWriter(file.getAbsoluteFile()) //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    ) {
            //Записываем текст у файл
            out.print(text);
        }
    } catch(IOException ex) {
        throw new RuntimeException(ex);
    }
                  List list_temp = Arrays.asList(text);;
                return list_temp;
  }
}
       
       public static void open_and_save_config() throws IOException
       {
           List<String> records;
           records = readFile("config.cfg");
           for (int i=0;i<records.size();i++)
           {
           String temp = records.get(i).trim();
     //      temp = temp.replaceAll(" ", "");
           temp = temp.replaceAll("=", "");
           records.set(0, temp);
           if (temp.matches("(.*)MYSQL(.*)"))
           {
              int start = 5; 
               int end = temp.length();
               MYSQL_ON = true;
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               server_db = String.valueOf(buf);
               System.out.println("msqlon" + server_db); 
           }
           if (temp.matches("(.*)USER(.*)"))
           {
              int start = 4; 
               int end = temp.length();
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               MYSQL_user = String.valueOf(buf);
               System.out.println("msqlon" + server_db); 
           }
           if (temp.matches("(.*)PASS(.*)"))
           {
              int start = 4; 
               int end = temp.length();
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               MYSQL_password = String.valueOf(buf);
               System.out.println("msqlon" + server_db); 
           }
           if (temp.matches("(.*)VERSION(.*)"))
           {
               int start = 7;
               int end = temp.length();
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               VERSION_ = String.valueOf(buf);
               System.out.println(VERSION_);
           }
           if (temp.matches("(.*)PATH(.*)") && (MYSQL_ON==false))
           {
               int start = 4; 
               int end = temp.length();
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               server_db = String.valueOf(buf);
               System.out.println(server_db);
            }
            if (temp.matches("(.*)OLD(.*)"))
           {
               int start = 3; 
               int end = temp.length();
               char buf[] = new char[end - start];
               temp.getChars(start, end, buf, 0);
               server_old_db = String.valueOf(buf);
               System.out.println(server_old_db);
            }
           }
       }
       
         
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void Conn() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException 
	   {
               listModelK.clear();
               listModel.clear();
               list_id_sad.clear();
               list_id_komp.clear();
                   comboModel.removeAllElements();
               list.clear();
               listK.clear();
               list_flag.clear();
               listK_new.clear();
               list_tr.clear();
                java.util.Date d = new java.util.Date();
                SimpleDateFormat format1 = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
                String computername=InetAddress.getLocalHost().getHostName();
		   conn = null;
		   
		  
               //    conn = DriverManager.getConnection("jdbc:sqlite:D:\\VNC\\PSE_db.sdb");
                   if (!MYSQL_ON)
                   {
                       Class.forName("org.sqlite.JDBC");
                   conn = DriverManager.getConnection("jdbc:sqlite:" + server_db);
                   
                   
                   File source = new File(server_db);
                 
                 
                    File dest = new File(server_old_db + format1.format(d) + "_" + computername + ".sdb");
//                    try {
//                    copyFileUsingJava7Files(source, dest);
//                    } catch (IOException e)
//                    {
//                        System.out.println("ВНИМАНИЕ! НЕ УДАЛОСЬ СДЕЛАТЬ БЭКАП!");
//                    }
                   }
                   else 
                   {
                    Class.forName("com.mysql.jdbc.Driver"); 
                    System.out.println("jdbc:mysql:" + server_db + MYSQL_user + MYSQL_password);
                       conn = DriverManager.getConnection("jdbc:mysql:" + server_db +"?characterEncoding=UTF-8",MYSQL_user,MYSQL_password);
                   }
                 File tvn_src = new File("tvnviewer.exe");
                 File cmd_own = new File("cmdow.exe");
                 File tvn_dest = new File("C:\\Windows\\System32\\tvnviewer.exe");
                 File cmd_dest = new File("C:\\Windows\\System32\\cmdow.exe");
                 try {
                  copyFileUsingJava7Files(tvn_src, tvn_dest);

                 } catch (IOException e)
                 {
                    System.out.println("TVNViewer или уже существует или его не удалось скопировать!"); 
                 }
		   
                                    
                    try {
                   copyFileUsingJava7Files(cmd_own, cmd_dest);
                   
                      } catch (IOException e)
                 {
                    System.out.println("Cmdow или уже существует или его не удалось скопировать! " + e.getMessage().toString()); 
                 }
		   
                   
                   System.out.println("База Подключена!");
	   }
	
	// --------Создание таблицы--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
               String vers = null;
               if (!MYSQL_ON)
               {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'Sadi' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' text, 'opisan' text);");
                statmt.execute("CREATE TABLE if not exists 'Komps' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' text, 'ips' text, 'flag' text);");
                statmt.execute("CREATE TABLE if not exists 'VERSION' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'GET_VERSION' text);");
		System.out.println("Таблица создана или уже существует.");
               }
               else 
               {
                   statmt = conn.createStatement();
		statmt.execute("SET NAMES 'utf8'");
 statmt.execute("CREATE TABLE IF NOT EXISTS `Sadi` (   `id` INT(11) NOT NULL AUTO_INCREMENT,  `number` TINYTEXT NOT NULL, `opisan` TINYTEXT NOT NULL,  PRIMARY KEY(`id`))");
 statmt.execute("CREATE TABLE IF NOT EXISTS `Komps` (  `id` INT(11) NOT NULL AUTO_INCREMENT,  `number` TINYTEXT NOT NULL, `ips` TINYTEXT NOT NULL,`flag` TINYTEXT NOT NULL,  PRIMARY KEY(`id`))");
 statmt.execute("CREATE TABLE IF NOT EXISTS `VERSION` (   `id` INT(11) NOT NULL AUTO_INCREMENT,  `GET_VERSION` TINYTEXT NULL,  PRIMARY KEY(`id`))");
 resSet3 = statmt.executeQuery("SELECT * FROM VERSION");
                while(resSet3.next())
                vers = resSet3.getString("GET_VERSION");
                if (vers == null)
                {
                     statmt.executeUpdate("INSERT INTO `VERSION` (GET_VERSION) VALUE ('"+VERSION_+"')");
                     statmt.executeUpdate("INSERT INTO `Sadi` (number,opisan) VALUES ('ТЕСТ','ТЕСТ')");
                     statmt.executeUpdate("INSERT INTO `Komps` (number,ips,flag) VALUES ('ТЕСТ','ТЕСТ','ТЕСТ')");
                }
		System.out.println("Таблица создана или уже существует.");
                
               }
	   }
	
        
  
        
	// --------Заполнение таблицы--------
//	public static void WriteDB() throws SQLException, IOException
//	{
//            
//            //Бэкапы базы
//            
//                 
//                java.util.Date d = new java.util.Date();
//                SimpleDateFormat format1 = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//                String computername=InetAddress.getLocalHost().getHostName();
//                    File source = new File("\\\\server\\remote\\PSE_db.sdb");
//                    File dest = new File("\\\\server\\remote\\PSE_db_old" + format1.format(d) + "__user__" + computername + ".sdb");
//                    copyFileUsingJava7Files(source, dest);
//                    
//                    
//              // Переписываем кол-во садов      
//                    statmt.execute("DELETE FROM 'Sadi'");
//		   for (int i=0; i < listModel.getSize(); i++)
//                   {
//                    statmt.execute("INSERT INTO 'Sadi' ('id', 'number', 'opisan') VALUES ('"+i+"', '" + listModel.getElementAt(i) +"', '"+ list.get(i)+"'); ");
//                   }
//                   
//                   
//                   
//             //Переписываем компы
//              statmt.execute("DELETE FROM 'Komps'");
//		   for (int i=0; i < listModelK.getSize(); i++)
//                   {
//                    statmt.execute("INSERT INTO 'Komps' ('id', 'number', 'ips') VALUES ('"+i+"', '" + listModelK.getElementAt(i) +"', '"+ listK.get(i)+"'); ");
//                   }
//             
//             
//		   System.out.println("Таблица заполнена");
//	}
	
	// -------- Вывод таблицы--------
        public static void insert_sad(String num, String opis) 
        {
            try {
                statmt.executeUpdate("INSERT INTO `Sadi` (number, opisan) VALUES ('"+ num +"', '"+ opis +"')");
            } catch (SQLException ex) {
                MainWindow.jLabel2_global.setText(ex.getMessage());
            }
        }
         public static void insert_komp(String uch, String num, String opis) 
        {
            
            try {
                statmt.executeUpdate("INSERT INTO `Komps` (number,ips,flag) VALUES ('"+uch+"','"+num+"','"+opis+"') ");
            } catch (SQLException ex) {
                MainWindow.jLabel2_global.setText(ex.getMessage());
                System.out.println(ex.getMessage());
            }
        }
         public static void edit_komp(String id, String uch, String num, String opis) 
        {
            try {
                  statmt.execute("UPDATE Komps SET number = '"+ num +"' WHERE id = '"+id+"'");
                statmt.execute("UPDATE Komps SET ips  = '"+ uch +"' WHERE id = '"+id+"'");
                  statmt.execute("UPDATE Komps SET flag = '"+ opis +"' WHERE id = '"+id+"'");
            } catch (SQLException ex) {
                MainWindow.jLabel2_global.setText(ex.getMessage());
            }
        }
          public static void edit_uch(String id, String num, String opis) 
        {
            try {
                statmt.execute("UPDATE Sadi SET number = '"+ num +"' WHERE id = '"+id+"'");
                statmt.execute("UPDATE Sadi SET opisan  = '"+ opis +"' WHERE id = '"+id+"'");
          //      statmt.execute("DELETE FROM Sadi WHERE id ="+id+"");
           //     statmt.execute("INSERT INTO `Sadi` ('id', 'number', 'opisan') VALUES ('"+id+"', '"+ num +"', '"+ opis +"');");
            } catch (SQLException ex) {
                MainWindow.jLabel2_global.setText(ex.getMessage());
            }
        }
         public static String del_komp(int id) 
         {
              try {
                statmt.execute("DELETE FROM Komps WHERE id ="+id+"");
            } catch (SQLException ex) {
              return ex.getMessage();
            }    
             return null; 
         }
         
         public static String del_sad(int id) 
         {
             try {
                statmt.execute("DELETE FROM Sadi WHERE id ="+id+"");
            } catch (SQLException ex) {
              return ex.getMessage();
            }    
             return null;
         }
	public static boolean ReadDB() throws ClassNotFoundException, SQLException
	   {
               
             //Читаем кол-во детских садов
               
		resSet = statmt.executeQuery("SELECT * FROM Sadi");
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String number = resSet.getString("number");
			String opisan = resSet.getString("opisan");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + number );
	         System.out.println( "opisan = " + opisan);
	         System.out.println();
                 listModel.addElement(number);
                 list_id_sad.add(id);
                 comboModel.addElement(number);
                 list.add(opisan);
		}	
                
                //Читаем компьютеры
                
                resSet2 = statmt.executeQuery("SELECT * FROM Komps");
                while(resSet2.next())
		{
			int id = resSet2.getInt("id");
			String number = resSet2.getString("number");
			String ips = resSet2.getString("ips");
                        String flag = resSet2.getString("flag");
	         System.out.println( "ID = " + id );
	         System.out.println( "number = " + number );
	         System.out.println( "ips = " + ips);
                 System.out.println( "flag = " + flag);
                 System.out.println( "size = " + list_id_komp.size());
	         System.out.println();
                 listModelK.addElement(number);
                 list_id_komp.add(id);
                 listK.add(ips);
                 list_flag.add(flag);
		}	
		
                resSet3 = statmt.executeQuery("SELECT * FROM VERSION");
                while(resSet3.next())
                VERSION_DB = resSet3.getString("GET_VERSION");
                    try 
                    {
                        if ((!VERSION_DB.equals(VERSION_))) 
                        {   
                   FRAME_UPDATE frame = new FRAME_UPDATE();
                   frame.setLocationRelativeTo(null);
                   welc.dispose();
                    frame.setVisible(true);
                    return false;
                }
                }
                catch (Exception E)
                {
                    FRAME_UPDATE frame = new FRAME_UPDATE();
                    frame.setTitle("ОШИБКА БАЗЫ ДАННЫХ version или version_db " + E.getMessage());
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    return false;
                }
		System.out.println("Таблица выведена");
                return true;
	    }
	
		// --------Закрытие--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			if (MYSQL_ON) statmt.close();
			resSet.close();
                        resSet2.close();
			resSet3.close();
			System.out.println("Соединения закрыты");
		   }

}

