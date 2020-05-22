public class Agenda implements java.io.Serializable {

    public static void addContact() {

    String nom, ap1, ap2, tf, em;

    Contact newContact = new Contact("Nombre", "Apellido", "Apellido 2", "Telefono", "Email");

    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("agenda.txt",true));
            oos.writeObject(newContact);
            oos.close();            

    } catch (IOException ex) {
        ex.printStackTrace(); 
        System.out.println("Ocurrió un error inesperado.");
    } 

    }
}