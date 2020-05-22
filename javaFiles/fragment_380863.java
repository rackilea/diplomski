String[] str={"abc","def","ghi"};
    String[] str1={"xyz","abc"};
    Set<String> set=new HashSet<String>();
    for (int i = 0; i < str.length; i++) {
        set.add(str[i]);
    }
    for (int i = 0; i < str1.length; i++) {
        set.add(str1[i]);
    }
    System.out.println(set.toString());