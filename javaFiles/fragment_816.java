Scanner scan = new Scanner(new File("D://practice.txt"));
ArrayList<String> names = new ArrayList<String>();
ArrayList<String> hobbies = new ArrayList<String>();

while(scan.hasNext()){
    String curLine = scan.nextLine();
    int indexOfHobby = curLine.indexOf(' ');
    names.add(curLine.substring(0, indexOfHobby).trim());
    hobbies.add(curLine.substring(indexOfHobby).trim());
}