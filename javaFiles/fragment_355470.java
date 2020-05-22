private void updateArrays(int x,int y){
  arrayCopy(xArray, 0, xArray, 1, xArray.length-1);//shift all elements backwards by 1
  arrayCopy(yArray, 0, yArray, 1, yArray.length-1);//so x at index 99 goes 98, 98 to 97, etc. excepting index 0
  xArray[0] = x;//finally add the newest value 
  yArray[0] = y;//at the start of the array (so in the next loop it gets shifted over by 1) like the above values
}