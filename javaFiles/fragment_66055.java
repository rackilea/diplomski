System.out.println("I am thinking of a letter between A and Z");
System.out.println("Can you guess it?");

ch = (char) System.in.read();

do {
    ignore = (char) System.in.read();
} while (ignore != '\n');