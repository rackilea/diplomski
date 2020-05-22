List<String> characters = new ArrayList<String>();
...Fill the List with the alphabet in order here (best to do in it's own method)
String initialString = yourString.getText().toString().toLowercase();
char[] chars = initialString.toCharArray();
for (int i = 1; i <= chars.length; i++) {
    C = Integer.valueOf(ceasarNr1);
    if ( i%2 ==0 ) C = Integer.valueOf(ceasarNr2);
    if ( i%3 ==0 ) C = Integer.valueOf(ceasarNr3);

    chars[i-1] = characters.get((characters.indexOf(chars[i-1]) + C)%29);
}
String resultString = new String(chars);
krypteredeTekst.setText(resultString);