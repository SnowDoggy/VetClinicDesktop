package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);

        return dbConnection;
    }

    public void signUpPatient(String owner, String phoneNumber,String dateOfVisit,String speciesOfAnimal,String breedOfAnimal,
                              String genderOfAnimal,String weightOfAnimal,String ageOfAnimal,String typeOfDiet,String vaccinationList,String reasonOfVisit){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_OWNER + "," + Const.USER_PHONENUMBER + "," + Const.USER_DATEOFVISIT + ","
                + Const.USER_SCPECIESOFANIMAL + "," + Const.USER_BREEDOFANIMAL + "," + Const.USER_GENDEROFANIMAL + "," + Const.USER_WEIGHTOFANIMAL + ","
                + Const.USER_AGEOFANIMAL + "," + Const.USER_TYPEOFDIET + "," + Const.USER_VACCINATIONLIST + "," + Const.USER_REASONOFVISIT + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,owner);
            prSt.setString(2,phoneNumber);
            prSt.setString(3,dateOfVisit);
            prSt.setString(4,speciesOfAnimal);
            prSt.setString(5,breedOfAnimal);
            prSt.setString(6,genderOfAnimal);
            prSt.setString(7,weightOfAnimal);
            prSt.setString(8,ageOfAnimal);
            prSt.setString(9,typeOfDiet);
            prSt.setString(10,vaccinationList);
            prSt.setString(11,reasonOfVisit);

            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
