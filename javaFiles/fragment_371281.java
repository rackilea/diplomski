Scanner scan = new Scanner(System.in);
//initialize to empty string
String mx = "";
System.out.println("Insert Month");
//use good naming conventions for easier code readability
String[] validMonths = {"january","february","march","april","may","june","july","august","september","october","november","december"};
//using a boolean to break makes much more sense than the way you have written it with an infinite loop and a manual break statement
boolean noMonth = true;
while (noMonth){
    mx = scan.nextLine();
    for(int i = 0; i < 12; i++){
        //rather than convert to lowercase, use this handy String method
        //also compares for valid number entries
        if (mx.equalsIgnoreCase(validMonths[i]) || mx.equals(Integer.toString(i+1))){
             noMonth = false;
             break;
        }
    }
    if(noMonth){
        System.out.println("please use a valid month or a number between 1 and 12");
    }
}
System.out.println(mx);