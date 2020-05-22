public static void main(String[] args) {

    Scanner kbd = new Scanner(System.in);
    System.out.print( "Enter a string of words that contains a hyphen: ");
    String word = kbd.next();

    int loc = word.indexOf('-');    //Here I am trying to find the location of that hyphen

    for (int i = word.length()-1; i > loc; i--) { //Now print the rest of the String in reverse TILL that location where we found hyphen. Notic i > loc           
        System.out.print(word.charAt(i));    
    }

        System.out.print(" ");

    for (int i = loc + 1; i < word.length(); i++) { //Now print the original String starting after the hyphen. Notice int i = loc + 1
        System.out.print(word.charAt(i));    
    }
}