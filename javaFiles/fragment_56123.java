LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(10);
    list.add(4);
    list.add(12);
    list.add(3);
    list.add(7);

    int min=Integer.MAX_VALUE;
    int pos=0;
    int remPos=0;
    Iterator<Integer> iterator = list.iterator();

    while(iterator.hasNext()){
        Integer element = iterator.next();
        if(element<min){
            min=element;
            remPos=pos;
        }
        pos++;
    }

    list.remove(remPos);
    list.forEach(System.out::println);