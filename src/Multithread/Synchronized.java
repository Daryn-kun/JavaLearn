package Multithread;

public class Synchronized {
    private int amount;

    // 1 thread: 10 -> 11 -> 12 -> 13 -> 14 (1 поток уже давно выполнил)
    // 2 thread: 10 -> 11 -> 12 (допустим 2 поток опаздывает, потом перезаписывает значения 1 потока заново)
    // нам нужно синхронизировать потоки чтобы конечное значение выходило корректно
    public static void main(String[] args) throws InterruptedException {
        Synchronized sync = new Synchronized();
        sync.working();
    }

    public void working() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    incMethod();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    incMethod();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Amount " + amount);
    }

    // synchronized синхронизирует потоки
    private synchronized void incMethod(){
        amount++;
    }
}
