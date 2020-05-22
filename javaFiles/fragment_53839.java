import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SerializeObservableListTest {

    public static void main(String[] args) throws IOException {
        EmployeeEntity bill = new EmployeeEntity("1000", "Seattle, WA", "1000", "Bill", "Gates");
        EmployeeEntity tim = new EmployeeEntity("2000", "Mobile, AL", "2000", "Tim", "Cook");

        ObservableList<EmployeeEntity> staff = FXCollections.observableArrayList(bill, tim);

        Path temp = Files.createTempFile("employees", "ser");
        write(staff, temp);

        ObservableList<EmployeeEntity> listFromFile = read(temp);
        System.out.println("Lists equal? "+listFromFile.equals(staff));
    }

    private static void write(ObservableList<EmployeeEntity> employees, Path file) {
        try {

            // write object to file
            OutputStream fos = Files.newOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<EmployeeEntity>(employees));
            oos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ObservableList<EmployeeEntity> read(Path file) {
        try {
            InputStream in = Files.newInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            List<EmployeeEntity> list = (List<EmployeeEntity>) ois.readObject() ;

            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.emptyObservableList();
    }
}