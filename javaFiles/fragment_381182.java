//save persons
public void savePersons(){
try{
    PersonsInfo p;
    String line;
    FileWriter fw= new FileWriter("input.txt");
    PrintWriter pw= new PrintWriter(fw);
    for (int i=0 ; i<persons.size();i++){
        p =(PersonsInfo)persons.get(i);
        line = p.getName() +","+ p.getAddress() +","+ p.getPhoneNum();
        pw.println(line);
    }
    pw.flush();
    pw.close();
    fw.close();
} catch (IOException ioEx){
System.out.println(ioEx);   
}