try{
    return queue.peek();
}catch(Exception e){
    System.out.println("Empty");
    throw new IllegalStateException("Empty");
}
// return statement is no longer required here