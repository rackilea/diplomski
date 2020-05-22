StringBuilder txt = new StringBuilder();  // get something to collect the output

for (Object obj : set.getEngCourse) { // If possible, change Object to the specific type
  // add a line break if we have already added something,
  if (txt.length() > 0) {
    txt.append("\n");
  }
  txt.append(String.valueOf(obj)); // will handle null objects
}

taken = new TextArea(txt.toString()); // assumes taken is declared elsewhere