package com.emidwife.web.models.dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.emidwife.web.models.entities.Child;
import com.emidwife.web.models.utilities.Database;


public class ChildNameAccess {
    private Database connection = new Database();

    public List<Child> getChildDataByMotherId(String motherID) throws SQLException {
        connection.openConnection();
        List<Child> children = new ArrayList<Child>();
        try{
            ResultSet resultSet = connection.getData("SELECT * FROM childdetails WHERE MotherID=\'" + motherID + "\'");
            while(resultSet.next()){
            Child child = new Child();
            child.setMotherId(resultSet.getString("MotherID"));
            child.setFirstName(resultSet.getString("FirstName"));
            child.setLastName(resultSet.getString("LastName"));
            children.add(child);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }

        return children;
    }
}