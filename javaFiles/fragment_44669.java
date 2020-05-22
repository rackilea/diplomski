public static char getChar() throws IOException{ 
    String buf= read.readLine(); 
    char chr = (char) buf.charAt(0); 
    while(buf.length() <= 1 && !Character.isLetter(chr)){ 
        System.out.println("This is not valid input. Please try again."); 
        buf= read.readLine(); 
        chr = (char) buf.charAt(0); 
    } 
    read.readLine(); 
    return chr; 
}