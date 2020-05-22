Scanner sc = new Scanner(System.in);
String code;
String tmpLine;

while (sc.hasNext()) {
    code = sc.next();//retrieve the code
    if (code.equals("R")) {
        tmpLine = sc.nextLine().trim();//read the entire rest of the line
        for(String s : tmpLine.split(" "))// split words by space
            socialNetwork.registerUser(s);
    }    
    else if (code.equals("M"))
    {
        System.out.print("The members are " + String.join(",", socialNetwork));//notice that I use String.join instead of toString
    }
}