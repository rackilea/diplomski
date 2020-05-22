switch(choice){
            case 1:
            println "Enter the conversion rate:";
            int rate = Integer.parseInt(scan.nextLine());
            c.customConversion(price,rate);
            break; 

            case 2:
            c.defaultConversion(price);
            break; 
        }//End of switch