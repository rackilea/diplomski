int day = -1;
Scanner scan = new Scanner(System.in);
System.out.println("Insert Day");
while (day < 1 || day > 31){  
    line = scan.nextLine();  
    if (line.matches(".*\\d.*")){
        day = Integer.parseInt(line);  
        if (day < 1 || day > 31){
            System.out.println("please use a valid number");       
        }  
    } else {  
        System.out.println("please use a number");  
    }
}