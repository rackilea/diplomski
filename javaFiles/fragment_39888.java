public static int addNum(String text){
    String numbers = "";
    int finalResult = 0;

    for(int i=0;i < text.length();i++){

        if(isNumeric(text.substring(i, i + 1)))
        {
            numbers += text.substring(i, i + 1);

            if(i==text.length()-1) {
                finalResult += Integer.parseInt(numbers); 
            }
        }else {
            if(!numbers.equals("")){
                finalResult += Integer.parseInt(numbers);
                numbers = "";
            }
        }
    }
    return finalResult;
}

public static boolean isNumeric(String str)  
{  
  try{  
    int d = Integer.parseInt(str);  
  }  
  catch(NumberFormatException ex){  
    return false;  
  }
  return true;  
}