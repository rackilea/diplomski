import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaBinaryFile {

    static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        addCar();
        saveFile();
        openFile();
    }

    public static void addCar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the make of the car?");
        String newMake = scan.next();
        System.out.println("What is the model of the car?");
        String newModel = scan.next();
        System.out.println("What year was the car produced?");
        String newYear = scan.next();
        System.out.println("How far has this car traveled?");
        String newOdometer = scan.next();
        cars.add(new Car(newMake, newModel, newYear, newOdometer));
    }

    public static void openFile() {
        try {
            FileInputStream fileIn = new FileInputStream("testSave.plzwork");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            try {
                ArrayList<Car> cars = (ArrayList<Car>) in.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void saveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("testSave.plzwork");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cars);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}