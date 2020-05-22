public static class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    public String name = null;
    public int    age  =   0;
}


public static void main(String[] args) throws  FileNotFoundException,IOException{

    Person person = new Person();
    person.name = "Prince";
    person.age  = 25;

    insert(person);

}

public static void insert(Person user) throws  FileNotFoundException,IOException{
    try(ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("c:/Sample/database.txt"))){
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

    } 
}