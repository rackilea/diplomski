Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File("file.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    int numberword=100;
    int count=0;
    while (sc2.hasNextLine() && count<numberword) {
            Scanner s2 = new Scanner(sc2.nextLine());
        boolean b;
        while (b = s2.hasNext() && count<numberword) {
            String s = s2.next();
            count++;
            System.out.println(s);
        }
    }