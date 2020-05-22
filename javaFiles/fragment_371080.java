private static void removeEvenLength(Set<String> thing) {
        thing.add("hi"); 
        thing.add("hello");
          Iterator<String> stuff = thing.iterator();
          System.out.println("set"+thing);
            while (stuff.hasNext()) {
                String temp = stuff.next();
                if (temp.length() %2 == 0) {
                    stuff.remove(); 
                }
            }
            System.out.println("set"+thing); 
}