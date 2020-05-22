// ***** don't create object *once* outside of the while loop!
//  ClassB object = new ClassB();

ArrayList<ClassB> arrayOfObjects = new ArrayList<>();
int count = 0;
while(count<10){

   // *** instead create a new one for each iteration of the loop!
   ClassB object = new ClassB(); // *****************

   ///alot going on here but the general concept is this;
  object.attribute1 = "something read in"
  object.attribute2 = "something read in"
  object.attribute3 = "something read in"
  object.attribute4 = "something read in"
  object.attribute5 = "something read in"   

  arrayOfObjects.add(object);
  count++;  
}