Scanner in = new Scanner(_file).useDelimiter("\\s+?|-");
ArrayList<Letter> letters = new ArrayList();
String from = in.next();
String to = in.next();
Letter temp = new Letter(from,to);
in.nextLine(); // <-- this is extra

// now we're ready to read the rest of the stuff
String s = in.nextLine();
temp.addLine(s);