if (fin != null && fin.hasNext()) { // do we have a scanner, is there anything to read?
  while (fin.hasNext()) { // while there's something to read...
    str = fin.next(); // read it.
    if (str == null) { // end if it's null?
      break;
    }
    dvdfile.add(str); // otherwise add it.
  }
}