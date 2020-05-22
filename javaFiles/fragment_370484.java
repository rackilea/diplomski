String in = "xhixhix";
  String out = in;
  while (!out.matches("[^x]*x*")) {
     out = out.replaceAll("x(.*)", "$1x");
  }
  System.out.println(out);