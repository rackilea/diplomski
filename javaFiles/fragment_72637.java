ArrayList<String> test_al = new ArrayList();
    test_al.add("hello world");

    if(hasSubstring(test_al, "hello")){
        Log.v(LOG_TAG,"True");
    }
    else{
        Log.v(LOG_TAG,"False");
    }