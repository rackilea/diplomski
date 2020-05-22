@Entity
public class User {

    long id;        

    String name;

    String email;

    Country country

    List<Images> uploadedImages;
}

@Entity
public class Country {

    long id;        

    String name;

}

@Entity
public class Image{

    long id;        

    String name;

    String url;

}