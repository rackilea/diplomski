final Iterator<Bee> myIter = cells.iterator();
while(myIter.hasNext()) {
    final Bee bee = myIter.next();
    try{
        bee.anotherDay();
    }catch(Exception e){
        myIter.remove();
    }
}