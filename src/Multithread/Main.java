package Multithread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // main thread
        // многопоточность
        // когерентность кэшей

        MyThread myThread = new MyThread("tr1");
        myThread.start();

//        Thread thread = new Thread(new RunThread());
//        thread.run();
        System.out.println("Main thread");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.stopThread();
    }
}

class MyThread extends Thread {
    private String name;
    // volatile - другие потоки смогут увидеть изменения по этой переменной,
    // переменная будет хранится в оперативной памяти, а не в кэше (у каждого потока есть свой кэш)
    private volatile boolean check = true;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (check){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hello");
        }
    }

    public void stopThread(){
        this.check = false;
    }
}

class RunThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
                System.out.println("hello from runnable thread class " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
