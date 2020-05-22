@Entity
public class User {
    long id;        
    String name;
    String email;

    int countryCode;

    List<Images> uploadedImages;
}