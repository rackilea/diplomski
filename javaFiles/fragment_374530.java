public static void print(CDLL<Character> list) {
  String str = "";
  CDLL<Character> first = null;
  while (true) {
    str += list.getPrevious().getValue() + " ";
    if (first == null) 
       first = list.getPrevious();
    else if (first == list.getPrevious())
       break;
    list = list.getPrevious();
  }
  System.out.print(str);
}