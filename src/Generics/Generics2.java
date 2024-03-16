package Generics;

public class Generics2 {
    public static void main(String[] args) {
        Body body = new Body();
        OilEngine oilEngine = new OilEngine();
        Car<OilEngine> car = new Car(body, oilEngine);
        car.getOilEngine().economyDrive();
    }
}

class Car<T extends Engine> {
    private Body body;
    private T oilEngine;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public T getOilEngine() {
        return oilEngine;
    }

    public void setOilEngine(T oilEngine) {
        this.oilEngine = oilEngine;
    }

    public Car(Body body, T oilEngine) {
        this.body = body;
        this.oilEngine = oilEngine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", oilEngine=" + oilEngine +
                '}';
    }
}

class Body{

}

class Engine{
    @Override
    public String toString() {
        return "Engine{}";
    }
}

class OilEngine extends Engine{
    void economyDrive(){
        System.out.println("i am economy master!!!");
    }
}

class ElectricEngine extends Engine{

}

class GasEngine extends Engine{

}
