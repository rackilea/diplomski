String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Now","Dec"};
int monthNumber;

Scanner scan = new Scanner(System.in);

System.out.println("Please input your month number: ");
monthNumber = (scan.nextInt());

    switch(monthNumber) {
        case 1 :
            System.out.println(months[0]); 
            break;
        case 2 :
            System.out.println(months[1]); 
            break;
        case 3 :
            System.out.println(months[2]); 
            break;
        case 4 :
            System.out.println(months[3]); 
            break;
        case 5 :
            System.out.println(months[4]); 
            break;
        case 6 :
            System.out.println(months[5]); 
            break;
        case 7 :
            System.out.println(months[6]); 
            break;
        case 8 :
            System.out.println(months[7]); 
            break;                
        case 9 :
            System.out.println(months[8]); 
            break;
        case 10 :
            System.out.println(months[9]); 
            break;
        case 11 :
            System.out.println(months[10]); 
            break;
        case 12 :
            System.out.println(months[11]); 
            break;            
         default :
            System.out.println("Invalid Month Number");
      }