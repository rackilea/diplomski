while (s.hasNext()){
    if(s.hasNextInt()){
        list.add(s.nextInt());
    } else {
        s.next();
    }
}