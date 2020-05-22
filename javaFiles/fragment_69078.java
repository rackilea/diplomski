// insert this before reading the filename
StringBuilder content = new StringBuilder();

s = read.next();

     while( !s.equals(".")) {
         content.append(s);
         content.append(String.format("%n"));
         s = read.next();
    }