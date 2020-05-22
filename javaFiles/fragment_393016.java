List<String> list = new ArrayList<>();
    for (int i = 1; i < 11; i++) {
        list.add(i+"");
    }
    List<List<String>> lists = new ArrayList<>();
    int x = list.size()/4;
    int y = list.size()%4;
    int j = 0;
    for (int i = 0; i < list.size(); i=j) {
        j = i+x;
        if(y>0){
            j++;
            y--;
        }
        lists.add(list.subList(i, j));
    }
    System.out.println(list);
    System.out.println(lists);