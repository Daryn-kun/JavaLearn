package Multithread;

public class HomeWork1 {
    public static void main(String[] args) {
        Operation operation1 = new Operation("Open", 4);
        Operation operation2 = new Operation("Close", 6);
        Operation operation3 = new Operation("Pull", 2);
        Operation operation4 = new Operation("Push", 9);
        Operation operation5 = new Operation("Kick", 5);

        operation1.start();
        operation2.start();
        operation3.start();
        operation4.start();
        operation5.start();

    }
}

class Operation extends Thread{
    private String operationName;
    private int operationTime;

    public Operation(String operationName, int operationTime){
        this.operationName = operationName;
        this.operationTime = operationTime;
    }

    @Override
    public void run() {
        System.out.println("Operation '" + operationName + "' started");

        for (int i = 1; i <= operationTime; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Operation '" + operationName + "': " + i + " second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Operation " + operationName + " finished");
    }
}
