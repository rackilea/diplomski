Scanner scan = new Scanner(System.in);
String s = scan.nextLine();

try{
    val = Integer.parseInt(s);
}
catch(NumberFormatException ex){
    System.out.println("This is not an integer, please input an integer"); 
}