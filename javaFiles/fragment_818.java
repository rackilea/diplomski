Scanner scan = new Scanner(new File("D://practice.txt"));
ArrayList<Person> people= new ArrayList<Person>();

while(scan.hasNext()){
    String curLine = scan.nextLine();
    int indexOfHobby = curLine.indexOf(' ');
    people.add(new Person(curLine.substring(0, indexOfHobby).trim(), curLine.substring(indexOfHobby).trim() ));
}