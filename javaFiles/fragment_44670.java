public static char getChar() throws IOException{
        int buf= read.read();
        char chr = (char) buf;
        while(!Character.isLetter(chr)){
            buf= read.read();
            chr = (char) buf;
        }
        return chr;
    }