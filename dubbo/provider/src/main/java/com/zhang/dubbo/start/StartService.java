package com.zhang.dubbo.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartService {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                context.close();
            }
        });

        synchronized (StartService.class) {

            while (true) {

                try {

                    StartService.class.wait();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
