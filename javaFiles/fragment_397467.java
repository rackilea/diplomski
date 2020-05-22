String line = "2 2 2";
ArrayList myIntArray = new ArrayList();
int charCounter = 0;
int rawSize = 0;
while(charCounter < line.length()){
    char a_char = line.charAt(charCounter);
    if(a_char != ' '){
        System.out.print(String.valueOf(a_char)+" ");
        int temp = Character.digit(a_char, 10);
        myIntArray.add(temp);
        System.out.println(String.valueOf(myIntArray.get(rawSize)));
        rawSize++;
    }
    charCounter++;
}