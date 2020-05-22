if (resultLength > 0) {
    while (baseInput.length() !=1)
        {
           System.out.println(baseInput);
           int tmpLen = resultLength % baseInput.length(); //finding char position to strike
           if(tmpLen != 0)
           {
               temp = baseInput.substring(tmpLen) + baseInput.substring(0, tmpLen-1); //Append part start from next char to strike and first charater to char before strike.
           }
           else
           {
               temp = baseInput.substring(0, baseInput.length()-1); //If mod result zero we can strike last letter easily
           }
           baseInput = temp; //Assign the temp to baseinput for next iteration.
        }
        relationIs = baseInput.charAt(0);
        System.out.println(relationIs);
 }