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

            //insert query
            String insertQuery = String.format("Insert into students(name,age,marks) values('%s',%o,%f)",
                    "Abhinil",23,74.0);

            //update query
            String updateQuery = String.format("Update students set marks = %f where id =%d",82.9,9);

            //delete query
            String deleteQuery = String.format("Delete from students where id=%d",5);
            //used for retrieving data
            ResultSet resultSet = statement.executeQuery(query);

            //used for insert,update or delete. Returns an integer and not resultset
//            int rowsAffected = statement.executeUpdate(insertQuery);
//            int rowsAffected = statement.executeUpdate(updateQuery);
            int rowsAffected = statement.executeUpdate(deleteQuery);

            if(rowsAffected>0)
                System.out.println("Operation successful");
            else
                System.out.println("Operation aborted");

            //method to iterate over result set
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//
//                System.out.println(id + name + age + marks);
//
//            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
