ArrayList<MyObject> items = new ArrayList<MyObject>();
    File fn = new File("test.txt");
    String[] astring = new String[4];
    try {
        Scanner readFile = new Scanner(fn);
        Scanner as = new Scanner(System.in);
        MyObject myObject;
        while (readFile.hasNext()) {
            astring = readFile.nextLine().split(",");
            myObject = new MyObject();

            myObject.code = astring[0];
            myObject.description  = astring[1];
            myObject.price = astring[2];

            items.add(myObject);

        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }