File file = new File("/home/keerthivasan/Desktop/input.txt");
     Scanner scr = null;
         try {
            scr = new Scanner(file);
            while(scr.hasNext()){
                System.out.println("line : "+scr.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScannerTest.class.getName()).log(Level.SEVERE, null, ex);
        }