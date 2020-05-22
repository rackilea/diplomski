} else {
    str = src.next().trim();
    str = str.replace('\n', '_');
    str = str.replace('\r', '_');
    System.out.println("String: " + str);
  }