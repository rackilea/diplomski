import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList; 


class Usuarios implements Serializable { // will need to implement Serializable class
    private static final long serialversionUID = 129348938L; // this is needed
    String name; 
    int age; 

    // Default constructor 
    public Usuarios(String name, int age) { 
        this.name = name; 
    } 

} 

public class Main { // Example class for Serialization and deserialization
    // method for printing the object
    public static void printdata(Usuarios object1) {   
        System.out.println("name = " + object1.name); 
        System.out.println("age = " + object1.age); 
    } 

    public static void serialize(ArrayList<Usuarios> list, String filename){
        // Serialization 
        try { 

            // Saving of object in a file 
            FileOutputStream file = new FileOutputStream 
                                           (filename); 
            ObjectOutputStream out = new ObjectOutputStream 
                                           (file); 

            // Method for serialization of object 
            out.writeObject(list); 
            out.close(); 
            file.close(); 

            System.out.println("Object has been serialized");
        } 

        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        }
    }

    public static ArrayList<Usuarios> deserialize(String filename){
    // Deserialization 
        try { 

            // Reading the object from a file 
            FileInputStream file = new FileInputStream 
                                         (filename); 
            ObjectInputStream in = new ObjectInputStream 
                                         (file); 

            // Method for deserialization of object 
            ArrayList<Usuarios> list = (ArrayList<Usuarios>)in.readObject(); 
            System.out.println("Object has been deserialized");

            in.close(); 
            file.close(); 
            return list;
        } 

        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        } 

        catch (ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException" + 
                                " is caught"); 
        } 
        return null;
    }


    public static void main(String[] args) { 
        Usuarios object1 = new Usuarios ("ab", 20); 
        Usuarios object2 = new Usuarios ("cd", 21); 
        String filename = "s.txt"; 

        ArrayList<Usuarios> EncuestadosBeforeSerialization = new ArrayList<>();
        EncuestadosBeforeSerialization.add(object1);
        EncuestadosBeforeSerialization.add(object2);

        System.out.println("Data before Deserialization."); 
        for (Usuarios object: EncuestadosBeforeSerialization) {
            printdata(object);
        }; 

        serialize(EncuestadosBeforeSerialization, filename);

        System.out.println("\n\nData will be Deserialize."); 

        ArrayList<Usuarios> EncuestadosAfterSerialization = deserialize(filename);
        System.out.println("Data after Deserialization."); 
        for (Usuarios object: EncuestadosAfterSerialization) {
            printdata(object);
        }; 
    } 
}