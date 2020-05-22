Scanner in = new Scanner(System.in);  

    System.out.println("Enter the &'s and ,'s");
    String x = in.next();

    System.out.println("Enter the numbers");
    String y = in.next();

    // here begins the new part

    String output = x.replace("&", "*");  // first replace all & with *
    String separator = "";                // check what kind of separator to use (, or .)
    if (x.contains(",")) {
        separator = ",";
        output = output.replace(",", ""); // remove all the , (we won't need them anymore)
    } else if (x.contains(".")) {
        separator = "."; 
        output = output.replace(".", ""); // remove the .
    }

    // now get the substring with the * that you keep and remove as many * as you need for the number
    output = output.substring(0, output.length() - y.length());  
    // just append the number to your output String
    output += y;

    System.out.println("output without the "+separator+"'s :\n"+ output);  // this is just to check if all *s where replaced correctly

    int remainingLength = output.length();    // we start at full length
    while (remainingLength / 3 > 0) {         // at every 3rd digit we want a separator (but not if the number has less only 3 or less digits) 
        // first our failsave: if there is a * in the substring we want to separate by a , or . then we are finished– break the loop and stop 
        if(output.substring(remainingLength - 3).contains("*")){
            break;
        }

        // otherwise form a new string of the substring before the separator, append the separator and the just add the other substring from after the seperator        
        output = output.substring(0, remainingLength - 3) + separator + output.substring(remainingLength - 3);
        remainingLength-=3;  // we just put a , after the 3 next digits          
    }
    System.out.println("output with the "+separator+"'s :\n"+ output);