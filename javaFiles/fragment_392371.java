class Someclass{

   public SomeClass(List list){
        list.add(this); //this is leaked outside before complete creation, constructor is still not complete

        //do some other chores to create this object
   }
}