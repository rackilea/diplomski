ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>(); 

    while (ts2.next()) {
        ArrayList<String> list = new ArrayList<String>();
        list.add( ts2.getString("userName");
        list.add(ts2.getString("userId"));  
        array.add(list);
    }