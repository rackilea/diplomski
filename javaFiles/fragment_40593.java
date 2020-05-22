ArrayList<String> meals = new ArrayList<String>();
String select = "";
while(!select.equals("")){
System.out.println("What would you like to do?");
System.out.println("1. <Irrelevant>");
System.out.println("2. Enter an idea");
System.out.println("3. <Irrelevant>");
System.out.println("4. <Irrelevant>");
System.out.println("Q. <Irrelevant>");

select = in.next();
in.nextLine();   // add this extra line in your code
switch(select){
    case "1":
        //Some stuff here.
    case "2":
        System.out.println("\nWhat is your idea? ");                  
        String i = in.nextLine();                               
        meals.add(i);    
        System.out.println("\n" + i + " has been entered into the idea pool. \n");
    case "3":
        //More stuff here
    //and so on...    
}