PrintWriter writer = new PrintWriter("C:/Users/r7h8/Output.txt", "UTF-8");
    writer.println("Vowels: " + vowels);
    writer.println("Digits : " + digits);
    writer.println("Spaces : " + spaces);
    writer.println("Capital Letters : " + upperCase);
    writer.println("LoweCase : " + lowerCase);
    writer.flush();
    writer.close();