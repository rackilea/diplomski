char[] stringasarray = text.toCharArray();
int length = text.length;

for(int i=0; i<length; i++){
    int letter1 = rnd.nextInt(length);
    int letter2 = rnd.nextInt(length);

    char temp = stringasarray[letter1];
    stringasarray[letter1] = stringasarray[letter2];
    stringasarray[letter2] = temp;
}
String newtext = new String(stringasarray);