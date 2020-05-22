private static String inputLine = "";

synchronized static String getInputLine() {
    return inputLine;
}

synchronized static void setInputLine(String line) {
    inputLine = line;
}

public static void main(String[] args) {

    char c;
    char allowed[] = {'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','\n','\r','\b'};

    ConsoleReader reader;
    PrintWriter out = new PrintWriter(System.out);

    new Thread(() ->{ //Asynchronous output test every 2 sec
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String erase = ""; //Prepare a string as long as the input made \b characters
            for(int i = 0 ; i < getInputLine().length() ; i++)
                erase += '\b';

            String whitespace = ""; //Prepare a string of whitespaces to override the characters after "test" (thus -4)  
            for(int i = 0 ; i < getInputLine().length() - 4 ; i++)
                whitespace += ' ';

            out.print(erase); //Erase the input line                
            out.println("test" + whitespace);
            out.print(getInputLine());
            out.flush();
        }
    }).start();

    try {
        reader = new ConsoleReader();
        reader.setBellEnabled(false);

        while(true){
            c = (char) reader.readCharacter(allowed);

            if(c == '\r' || c == '\n') {

                //Do something with the input

                setInputLine("");
                out.println();
            } else if(c == '\b') { //Backspace
                String line = getInputLine();
                setInputLine(line.substring(0, line.length()-1));
                out.print(c);
                out.print(" "); //Print whitespace to erase trailing char
                out.print(c); //Backspace again to send the carret back to the last char
            } else {
                setInputLine(getInputLine() + c);
                out.print(c);
            }

            out.flush();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}