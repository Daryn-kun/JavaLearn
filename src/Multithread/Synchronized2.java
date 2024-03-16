package Multithread;

import java.util.ArrayList;
import java.util.List;

public class Synchronized2 {
    public static void main(String[] args) {
        new Test().testingThread();
    }
}

class Test {
    private List<Integer> num1 = new ArrayList<>();
    private List<Integer> num2 = new ArrayList<>();

    Object locker1 = new Object();
    Object locker2 = new Object();

    void addNumsToNums1(){
        synchronized (locker1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            num1.add(200);
        }

    }

    void addNumsToNums2(){
        synchronized (locker2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num2.add(200);
        }
    }

    void testingThread(){
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();

        System.out.println("Time for program: " + (finish - start));
        System.out.println("num1 " + num1.size());
        System.out.println("num2 " + num2.size());
    }

    void work(){
        for (int i = 0; i < 1000; i++) {
            addNumsToNums1();
            addNumsToNums2();
        }
    }
}
