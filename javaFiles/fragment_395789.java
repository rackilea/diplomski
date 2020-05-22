public String conIntTOBin(String num) {
        String temp = "";

        for(int i=0; i < num.length(); i++) {                               
              temp += Integer.toBinaryString(Integer.parseInt(""+num.charAt(i)));
        }
        return temp;

 }