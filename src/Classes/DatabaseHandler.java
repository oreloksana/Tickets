package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void addTicketToDB(String ticketTyp, double ticketPrice, Date ticketDate){
        String insert = "INSERT INTO " + Const.TICKET_TABLE + "(" + Const.TICKET_TYP + "," +
                Const.TICKET_PRICE + "," + Const.TICKET_DATE + ")" + "VALUES(?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, ticketTyp);
            prSt.setDouble(2, ticketPrice);
            prSt.setDate(3, (java.sql.Date) ticketDate);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
