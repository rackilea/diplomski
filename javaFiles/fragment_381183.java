public class AddressBook{
ArrayList<PersonsInfo> persons;
public AddressBook (){
    persons = new ArrayList <PersonsInfo> ();
    loadPersons();
}
//Load Person
public void loadPersons (){
String tokens[]=null;
String name,address,phoneNum;
try{
    FileReader fr= new FileReader("input.txt");
    BufferedReader br= new BufferedReader(fr);
    String line=br.readLine();
    while (line !=null)
    {
        tokens = line.split(",");
        name=tokens[0];
        address=tokens[1];
        phoneNum=tokens[2];
        PersonsInfo p = new PersonsInfo(name,address,phoneNum);
        persons.add(p);
        line = br.readLine();
    }

br.close();
fr.close();

}catch (IOException ioEx) {
        System.out.println(ioEx);
}   
}