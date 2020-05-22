public class Program5 {
    private String name;
    private String mail;

    public Program5(){}

    void loadContacts(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a name and a mail like this : name email@email.com (separate with ' ')");
        String[] line = scan.nextLine().split(" ");
        while(line.length!=2){
            System.out.println("Again, enter a name and a mail like this : name email@email.com (separate with ' ')");
            line = scan.nextLine().split("/");
        }
        this.setName(line[0]);
        this.setMail(line[1]);
        scan.close();
    }

    void printContacts() {
        System.out.println("NAME : "+this.name+"\nEMAIL : "+this.mail);
    }

    public static void main(String[] args) {
        Program5 program5 = new Program5();
        program5.loadContacts();
        program5.printContacts();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}