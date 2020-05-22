String atoz = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWXYZ0123456789";

    Map<String, String> wordTest = new HashMap<String, String>();

    //write logic

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 24223400; i++) {
        int begin1 = 1 + (int) (Math.random() * ((atoz.length() - 1) + 1));
        int end1 = begin1 + (int) (Math.random() * ((atoz.length() - begin1) + 1));
        int begin2 = 1 + (int) (Math.random() * ((atoz.length() - 1) + 1));
        int end2 = begin2 + (int) (Math.random() * ((atoz.length() - begin2) + 1));

        wordTest.put(atoz.substring(begin1, end1), atoz.substring(begin2, end2));
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Time taken:" + (endTime - startTime) + " ms to insert "
            + wordTest.size() + " records.");


    // Read logic  

    String atoz1 = "ABCDEFGHIJKLMNOPQURSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    int counter=0;
    long startTime1 = System.currentTimeMillis();
    for (int i = 0; i < 24223400; i++) {
        int begin1 = 1 + (int) (Math.random() * ((atoz1.length() - 1) + 1));
        int end1 = begin1 + (int) (Math.random() * ((atoz1.length() - begin1) + 1));

        if(wordTest.get(atoz1.substring(begin1, end1))==null){
            counter++;
        }
    }
    long endTime1 = System.currentTimeMillis();
    System.out.println("Time taken:" + (endTime1 - startTime1) + " ms to read " + 24223400
            + " records." + " Success hit:"+counter);