list = Arrays.asList(str.split(","));  
    for (int i = 0; i < list.size(); i += 3) {

        String name = list.get(i);
        String no = list.get(i + 1);
        String no1 = list.get(i + 2);
        System.out.println(name + no + no1);
        writeToDb(name, no, no1);
     }