for (Key key : Key.values()) { // run through the ALL of the keys
        if (keyMap.get(key)) { // if key in HashMap is true (i.e. the
                               // actionPerformed() above set it true)
           switch (key.toString()) {
           case "a":
              System.out.println("a");
              break;
           case "b":
              System.out.println("b");
              break;
           case "c":
              System.out.println("c");
              break;
           case "d":
              System.out.println("d");
              break;
           case "e":
              System.out.println("e");
              break;
           case "f":
              System.out.println("f");
           }

           // ***** add this *****
           keyMap.put(key, Boolean.FALSE);
        }
     }