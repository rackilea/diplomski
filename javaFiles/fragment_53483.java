Scanner s = new Scanner (new File ("a.txt")).useDelimiter("\\s+");
while (s.hasNext()) {
    if (s.hasNextInt()) { // check if next token is an int
        System.out.print(s.nextInt()); // display the found integer
    } else {
        s.next(); // else read the next token
    }
}