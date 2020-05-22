public static void main(String[] args){
    String[] myList = new String[] {"A","E","I","O","U","Y"};
    String text = "AEE";
    StringBuilder tempText = new StringBuilder("");
    String obify = "OB";
    for (char c : text.toCharArray()){
        tempText = tempText.append(c);
        if ( Arrays.asList(myList).contains(c+"") ) {
            System.out.println(c+" found.");
            tempText = tempText.append(obify);
        }
    }

    text = tempText.toString();
    System.out.println(text);
}