Scanner monthone = new Scanner(System.in);

int month;
System.out.println("What is the numerical value of the month? 1-12");    
//System.out.print(monthone.nextLine());    
month = monthone.nextInt();

switch (month){
case 1: 
System.out.println("It's January");
break;
case 2: System.out.println("It's Feburary");
break;