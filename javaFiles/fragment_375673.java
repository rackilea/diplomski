public class gTextFile {

static LinkedList<gText> list = new LinkedList<gText>();

public static void main(String[] args) throws FileNotFoundException {
    Scanner scnOne = new Scanner(System.in);

    String eCode;

    System.out.print("Employee Code: ");
    eCode = scnOne.nextLine();

    readFile();
    gEmpName(eCode);
}

public static void readFile() throws FileNotFoundException {
    File nFile = new File("/home/path/abc.txt");
    Scanner scnTwo = new Scanner(nFile);
    String oTemp;
        while(scnTwo.hasNext()) {
        oTemp = scnTwo.nextLine();
        String EmCode[] = oTemp.split(" ");
        String Name[] = EmCode[1].split(",");
        String idCode = EmCode[0];
        String lastname = Name[0];
        String firstname = Name[1];
        gText gT = new gText(firstname, lastname, idCode);
        list.add(gT);
        }
    scnTwo.close();
}

public static void gEmpName(String EmpCode) {
    Iterator<gText> itr = list.iterator();
    while(itr.hasNext()) {
        gText gT = itr.next();
        if(gT.id.equals(EmpCode)){
            System.out.println("Employee Name: " + gT.Fname + " " + gT.Lname);
        }

    }

}