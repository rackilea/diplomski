int day = -1;
Scanner scan = new Scanner(System.in);
System.out.println("Insert Day");
while (day < 1 || day > 31){
    line = scan.nextLine(); 
    try { 
        day = Integer.parseInt(line);
        if (day < 1 || day > 31){
            System.out.println("please use a valid number");       
        }  
    } catch (NumberFormatException e) {
        System.out.println("please use a number");  
    }
}