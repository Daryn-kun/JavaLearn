package Multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Worker1(1));
        executorService.submit(new Worker1(2));

        executorService.shutdown();
    }
}

class Worker1 implements Runnable{
    private List<Integer> nums = new ArrayList<>();
    private int id;

    public Worker1(int id) {
        this.id = id;
    }

    void timeChecking(){
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            nums.add(i + 5);
        }

        long finish = System.currentTimeMillis();

        System.out.println("ID: " + id + " Time is: " + (finish - start));
    }

    void addNums(){
        timeChecking();
        System.out.println("ID: " + id + " Nums size: " + nums.size());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            addNums();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Worker2 implements Runnable{
    private List<Integer> nums = new LinkedList<>();
    private int id;

    public Worker2(int id) {
        this.id = id;
    }

    void timeChecking(){
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            nums.add(i + 5);
        }

        long finish = System.currentTimeMillis();

        System.out.println("ID: " + id + " Time is: " + (finish - start));
    }

    void addNums(){
        timeChecking();
        System.out.println("ID: " + id + " Nums size: " + nums.size());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            addNums();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
