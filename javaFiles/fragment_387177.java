Scanner scan = new Scanner(System.in);
System.out.println("Insert Day");
int day = -1;
while (true){  
    line = scan.nextLine();  
    if (line.matches(".*\\d.*")){
        day = Integer.parseInt(line);  
        if (0 < day && day < 32){
            break;
        } else {  
            System.out.println("please use a valid number");       
        }  
    } else {  
        System.out.println("please use a number");  
    }  
}