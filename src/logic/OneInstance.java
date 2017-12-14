/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/**
 *
 * @author Силантьев Олег
 */

public class OneInstance {
    private static final String LOCK_FILE_NAME = ".lock";
       private static boolean lock() {
        try {
            // создаем блокировку
            final FileLock lock = new FileOutputStream(
                                           new File(LOCK_FILE_NAME))
                                              .getChannel().tryLock();
            if (lock != null) {
                // а вот и сам "фокус":
                // создаем поток...
                Thread t = new Thread(() -> {
                    while (true) {
                        try {
                            // ... и проверяем валидность блокировки
                            //     внутри него...
                            if (lock.isValid()) {};
                            // ... а затем засыпаем "навечно"
                            Thread.sleep(Long.MAX_VALUE);
                        } catch (InterruptedException e) {
                            // игнорируем
                        }
                    }
                });
                // запускаем поток как "демон",
                // чтобы не блокировать завершение выполнения основной части кода
                t.setDaemon(true);
                t.start();
            }
            return lock != null;
        } catch (IOException ex) {
            // игнорируем, если мы ничего не в силах поделать -
            // пользователь должен сам позаботиться о том,
            // чтобы не запускать на выполнение более одного экземпляра приложения
        }
        return true;
    }
     public static void singleAppInstanceCheck() throws Throwable {
        // проверка: запущен ли другой экземпляр приложения?
        if (!lock()) { // если да, то...
                System.out.println("Другая копия приложения уже запущена.");
            // ... и прекращаем работу
            System.exit(1);
             System.exit(1);
        }
    }
    
    
    
}
