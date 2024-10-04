package jdbc;

import java.sql.*;

public class PreparedStatementInterface {

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

            //query is compiled here and the same query can be used with values getting changed unlike
            // statement interface
            String query = "Insert into students(name,age,marks) values(?,?,?)";
            String query2 = "Select marks from students where id = ?";
            String updateQuery = "Update students set marks = ? where id =?";
            String deleteQuery = "Delete from students where id =?";
            //prepared statement instance created
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            //setting the values here
//            preparedStatement.setString(1,"Bot");
//            preparedStatement.setInt(2,22);
//            preparedStatement.setDouble(3,88.9);
//            preparedStatement.setInt(1,10);

            preparedStatement.setDouble(1,99.2);
            preparedStatement.setInt(2,10);
            //using executeUpdate because it's a CRUD operation, returns rows affected and not result set
            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected>0)
                System.out.println("Operation successful");
            else
                System.out.println("Operation aborted");

            //result set because we retrieve data
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next())
//                System.out.println("marks is "  + resultSet.getDouble("marks"));
//            else
//                System.out.println("marks not found");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
