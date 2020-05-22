public static int getDay() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Insert Day");
    while (true){  
        line = scan.nextLine();  
        if (line.matches(".*\\d.*")){
            int day = Integer.parseInt(line);  
            if (0 < day && day < 32){  
                return day;  
            } else {  
                System.out.println("please use a valid number");       
            }  
        } else {  
            System.out.println("please use a number");  
        }  
    }
}

public static void main(String[] args) {
    int day = getDay();
    System.out.println(day);  
}