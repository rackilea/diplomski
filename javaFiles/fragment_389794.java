do {
        System.out.print("Press a key followed by enter: ");
        ch = (char) System.in.read(); // get the char
        char ch1 = (char) System.in.read(); // carriage return
        char ch2 = (char) System.in.read(); // line feed
    } while (ch != 'q');