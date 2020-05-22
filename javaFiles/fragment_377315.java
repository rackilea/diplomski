public class Person {
    private int persID;
    private String persName;
    private String email;
    private static int nextPers = 0;

    Person(String persName, String email){
        this.persID = nextPers;
        nextPers++;
        this.persName = persName;
        this.email = email;
    }

    public static void main(String [] args){
        Person per = new Person("P0" , "p0@hotmail.com");
        System.out.println(per.persID + " " + per.email + " " + per.persName);
        per = new Person("P1" , "p1@hotmail.com");
        System.out.println(per.persID + " " + per.email + " " + per.persName);
        per = new Person("P2" , "p2@hotmail.com");
        System.out.println(per.persID + " " + per.email + " " + per.persName);
    }
}