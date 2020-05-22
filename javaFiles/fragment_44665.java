import java.util.*;
import java.io.*;

public class EmployeeFileHandler implements Serializable {
    public static void main(String[] args) {
        ArrayList<Employees> employees = new ArrayList<Employees>();
        for (int i = 0; i < 1000; i++) {
            employees.add(new Employees("Name" + i, "Surname" + i, "" + i, 12345678));
        }        
        writeDate(employees);

        ArrayList<Employees> employees2 = new ArrayList<Employees>();
        readData(employees2);

        assert employees.size() == employees2.size();
        for (int i = 0; i < 1000; i++) {
            Employees e = employees2.get(i);
            assert e.Name.equals("Name" + i);
            assert e.Surname.equals("Surname" + i);
            assert e.ID.equals("" + i);
            assert e.MobNo == 12345678;
        }        
    }

    public static void readData(ArrayList<Employees> listIn) {

        boolean endOfFile = false;
        Employees temp;

        try {

            FileInputStream employeesFile = new FileInputStream("employee.obf");
            ObjectInputStream employeesStream = new ObjectInputStream(employeesFile);
            temp = (Employees) employeesStream.readObject();

            while (endOfFile != true) {
                try {
                    listIn.add(temp);
                    temp = (Employees) employeesStream.readObject();
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
            employeesStream.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("Employee file was not found");
        } catch (IOException e) {
            System.out.println("Employee file could not be read");
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class was not found");
        }
    }

    public static void writeDate(ArrayList<Employees> employee) {

        try {
            FileOutputStream EmployeesFile = new FileOutputStream("employee.obf");
            ObjectOutputStream EmployeesStream = new ObjectOutputStream(EmployeesFile);

            for (Employees employees : employee) {
                EmployeesStream.writeObject(employees);
            }
            EmployeesStream.close();
        } catch (IOException e) {
            // System.out.println("Error occurred while saving");
            e.printStackTrace();
        }
    }
}