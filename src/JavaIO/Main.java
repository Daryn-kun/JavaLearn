package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(countWords("hello.txt"));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<User> users = new ArrayList<>();

        while (true){
            System.out.println("[1] add user");
            System.out.println("[2] list user");
            System.out.println("[3] exit");

            int ch = Integer.parseInt(bufferedReader.readLine());

            if (ch == 1){
                System.out.println("Enter id");
                int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter login");
                String login = bufferedReader.readLine();
                System.out.println("Enter pass");
                String pass = bufferedReader.readLine();
                users.add(new User(id, login, pass));
                saveUsersList(users);
            } else if (ch == 2) {
                for (User user : getUsersList()) {
                    System.out.println(user.toString());
                }
            } else
                break;
        }
    }

    private static ArrayList<User> getUsersList(){
        ArrayList<User> users = null;
        BufferedReader reader = null;
        String text;

        try {
            users = new ArrayList<>();
            reader = new BufferedReader(new FileReader("memory.txt"));
            while ((text = reader.readLine()) != null){
                String arr[] = text.split(" ");
                if (arr.length == 3){
                    users.add(new User(Integer.parseInt(arr[0]), arr[1], arr[2]));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    private static void saveUsersList(ArrayList<User> users){
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("memory.txt"));

            for (User user : users) {
                bufferedWriter.append(user + "\n");
            }

            bufferedWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static int countWords(String fileName){
        BufferedReader reader = null;
        String text;
        int count = 0;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((text = reader.readLine()) != null){
                count += text.split("\\s+").length;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return count;
    }
}

class User {
    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password;
    }
}
