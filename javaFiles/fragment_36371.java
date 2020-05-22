List<String[]> lines = new ArrayList<String[]>();
while ((thisLine = myInput.readLine()) != null) {
     lines.add(thisLine.split(";"));
}

// convert our list to a String array.
String[][] array = new String[lines.size()][0];
lines.toArray(array);