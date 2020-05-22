String number= Integer.toString(x);
char[] digits=number.toCharArray();
boolean result=false;
for(char c: digits) {
    if(Integer.parseInt(String.valueOf(c))>limit) {
        result=false;
    }
}
return result;