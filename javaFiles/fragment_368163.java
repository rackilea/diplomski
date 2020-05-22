public class Person  
{ 
    private String navn; 
    private int personNummer;
    private int alder;

    public Person (String navn, int personNummer, int alder)
    { 
        this.navn = navn;
        this.personNummer = personNummer;
        this.alder = alder;
    } 

    public String getName() {
        return this.navn;        
    }   
}

public class Kunderegister { 
    private Scanner input;
    private Person [] brukere;
    int i = 0;

    public Kunderegister ()  
    { 
        input = new Scanner(System.in);
        brukere = new Person [20];
    } 

    public void leggTilBruker() 
    { 
        System.out.println("give the name"); 
        System.out.println("Give name");
        String name = input.nextLine();
        System.out.println("Give age");
        int age = input.nextInt();
        System.out.println("Give number");
        int number = input.nextInt();
        Person a = new Person(name,number,age);
        brukere[i]=a;
        i++;
    } 

    public void visPersonListe() 
    { 
        for (int j = 0; j < brukere.length; j++) {
            System.out.println(brukere[j].getName());
        } 
    }