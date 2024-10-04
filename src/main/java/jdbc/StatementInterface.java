package jdbc;

import java.sql.*;
public class StatementInterface {

    //initialization variables
    private static final String URL ="jdbc:mysql://localhost:3306/mydb";
    private static final String username ="root";
    private static final String password ="admin";

    public static void main(String[] args) {

        //loading and registering necessary drivers
        try {
            Class.forName("com.mysql.cj.jdbc.driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            //creating connection
            Connection connection = DriverManager.getConnection(URL,username,password);

            //creating statement interface to execute queries
            Statement statement = connection.createStatement();

            //test query
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);

            //method to iterate over result set
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.println(id + name + age + marks);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
