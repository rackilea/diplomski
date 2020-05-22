HashMap<String,String> hm=new HashMap<String,String>();
    hm.put("Key A","A");
    hm.put("Key B","B");
    hm.put("Key C","C");
    hm.put("Key D","D");
    for(Map.Entry m : hm.entrySet()){
        if (list.contains(m.getValue()))
            System.out.println("Bingo: " + m.getKey());
    }