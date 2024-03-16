package Generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Sportsman> sportsmenList = new ArrayList<>();
        sportsmenList.add(new Sportsman("Erlan"));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Arman"));
        testSportsman(sportsmenList);
        testSportsman(players);
    }

    private static void testSportsman(List<? extends Sportsman> sportsmen){
        for (Sportsman sportsman : sportsmen) {
            System.out.println(sportsman);
        }
    }
}

class Sportsman{
    private String name;

    public Sportsman(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Player extends Sportsman{
    public Player(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Player{}";
    }
}
