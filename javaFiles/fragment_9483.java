List<String> lines = new LinkedList<String>(); // create a new list
String line = in.readLine(); // read a line at a time
while(line != null){ // loop till you have no more lines
    lines.add(line) // add the line to your list
    line = in.readLine(); // try to read another line
}