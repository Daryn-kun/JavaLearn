package Multithread;

public class HomeWork2 {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("Honda", 60),
                new Car("Toyota", 90),
                new Car("Hyundai", 70),
                new Car("Nissan", 60),
                new Car("Zeekr", 75),
                new Car("Kia", 80),
                new Car("BMW", 100),
        };

        for (Car car : cars) {
            car.start();
        }
    }
}

class Car extends Thread{
    private String name;
    private int speed;
    private double distance;
    private static int finishLine = 1000;

    public Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while (distance < finishLine){
            try {
                Thread.sleep(1000);
                distance += speed;
                System.out.println(name + " is in " + distance + " meters");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long finish = System.currentTimeMillis();
        System.out.println(name + " finished in " + ((finish - start) / 1000) + " seconds");
    }
}
