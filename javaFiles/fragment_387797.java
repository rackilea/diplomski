Iterator<ParseObject> it = objects.iterator();
while(it.hasNext()){
    Object object = it.next();
    //your stuff
    it.remove();
}