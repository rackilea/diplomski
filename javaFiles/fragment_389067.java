public static ArrayList<String> get_arraylist_from_file(File f) 
    throws FileNotFoundException {
    Scanner s;
    ArrayList<String> list = new ArrayList<String>();
    s = new Scanner(f);
    while (s.hasNext()) {
String temp=s.next();
        System.out.println(temp);
        list.add(temp);
    }
    s.close();
    return list;
   }
}