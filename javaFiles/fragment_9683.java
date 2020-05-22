//actorClass is a Class<T> object that represents Actor.class 
//or any of its subtypes
Class<? extends Actor> actorClass = Actor.class;

//classArray is an array of Class<? extends Actor> objects, and so its type is 
//Class<? extends Actor>[]
//You will get a warning about an unsafe cast here because you
//cannot really create an array of generic type, which means the
//RHS type is just `Class[]`.
Class<? extends Actor>[] classArray = new Class[] {
    actorClass, actorClass, actorClass
}; 

//Now we get the class of the array itself, which matches the convoluted
//expression you saw.
Class<? extends Class<? extends Actor>[]> classArrayClass = classArray.getClass();