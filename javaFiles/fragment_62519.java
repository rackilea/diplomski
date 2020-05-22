String st1 = "RACECAR";
int flag=0;   
    for (int j=0;j<=str1.length()-1 ;j++)   
    {   
     if (st1.charAt(j)!=st1.charAt(st1.length()-j-1))   
     {   
     flag=1;   
     break;   
     }   
    }  
  if(flag==1)   
  System.out.println("String is not a palindrome");   
  else   
    System.out.println("String is a palindrome");