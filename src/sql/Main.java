package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/javacourse";
    private static String user = "postgres";
    private static String pass = "1234";

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection completed");
        } catch (Exception e){
            e.printStackTrace();
        }

//        addUser(new User(null, "Daryn", 22));
        deleteUser(2);
        getUsers().forEach(System.out::println);
    }

    // insert query
    private static void addUser(User user){
        String query = "insert into users(name, age) values(?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("inserting completed");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // select query
    private static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query        = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Long id     = resultSet.getLong("user_id");
                String name = resultSet.getString("name");
                int age     = resultSet.getInt("age");

                users.add(new User(id, name, age));
            }

            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    // delete query
    private static void deleteUser(int id){
        try {
            Statement statement = connection.createStatement();
            String query        = "delete from users where user_id = " + id;
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class User{
    private Long   id;
    private String name;
    private int    age;

    public User(Long id, String name, int age) {
        this.id   = id;
        this.name = name;
        this.age  = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
