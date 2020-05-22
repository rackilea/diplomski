for (int i = 0; i < temp.length() - 1; i++) {
   if (temp.charAt(i) == '0') {
         temptemp = temptemp + "000";
   } else if (temp.charAt(i) == '1') {
        temptemp = temptemp + "001";
   } else if (temp.charAt(i) == '2') {
        temptemp = temptemp + "010";
   } else if (temp.charAt(i) == '3') {
        temptemp = temptemp + "011";
    } else if (temp.charAt(i) == '4') {
        temptemp = temptemp + "100";
    } else if (temp.charAt(i) == '5') {
        temptemp = temptemp + "101";
    } else if (temp.charAt(i) == '6') {
         temptemp = temptemp + "110";
    } else if (temp.charAt(i) == '7') {
        temptemp = temptemp + "111";
   }
}