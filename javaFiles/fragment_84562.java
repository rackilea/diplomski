public static boolean insipid(int num){
  boolean returnValue = false;
  if(num == 58){ //The number is not insipid
   //do nothing
  } if(num == 1){ // the number is insipid
    returnValue = true;
  }else{
    int dig1 = 0, dig2 = 0, dig3 = 0; // num = 159 for example, dig1 would be 1. Default is 0 in case of a 2   digit number, dig1*dig1 = 0
    if (num < 10){
        returnValue = insipid(num * num);
    }
    else if(num>99){
        dig1 = (int)(num / 100);
        dig2 = (int)((num - 100)/10);
        dig3 = num - (((int)(num / 10))*10);
        returnValue = insipid(squaresum(dig1,dig2,dig3));
    }
    else{
        dig2 = (int)(num/10); //The 10s place
        dig3 = num - (((int)(num/10)) * 10); //the 1s place
        returnValue = insipid(squaresum(dig1, dig2,dig3)); //dig1 = 0 so I just pass it along with it.
    }
  }
  return returnValue ;
}