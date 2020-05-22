ListIterator li = al.listIterator();
    while(li.hasNext()){
        int ab = (int) li.next();
        if (ab > 4){
            li.previous();
            break;
        }
    }