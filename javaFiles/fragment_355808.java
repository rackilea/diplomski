String original[] = { "1","2","3","4","6"};
     String testStr[] = { "1","2","3","5","7" };
        List origList = new ArrayList(Arrays.asList(original));
        List testList = new ArrayList(Arrays.asList(testStr));

        System.out.println(origList.removeAll(testList));
        System.out.println(origList);