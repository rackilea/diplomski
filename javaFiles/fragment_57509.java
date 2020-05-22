int currentKeySize = 8;

    String message = new String();
    message="This is a test message";   
    List<String> list = new ArrayList<String>();

    for (int i = 0; i < currentKeySize; ++i) {
        list.add(i % currentKeySize, "");
    }
    for (int i = 0; i < message.length(); ++i) {      
        list.set(i % currentKeySize, list.get(i % currentKeySize) + message.charAt(i));
    }
    for (int i = 0; i < list.size(); ++i) { 
        System.out.println(list.get(i));
    }