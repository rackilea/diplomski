CopyOnWriteArrayList<String> bList = new CopyOnWriteArrayList<String>();
    bList.add("1");
    bList.add("2");
    bList.add("3");
    bList.add("4");
    bList.add("5");

int i = 0;
    for (String s : bList) {
        System.out.println("outer: " + s);
        int j = 0;
        l: for (String s2 : bList) {
            while(j < i) {
                j++;
                continue l;
            }
            System.out.println("inner: " + s2);
        }
        i++;
    }