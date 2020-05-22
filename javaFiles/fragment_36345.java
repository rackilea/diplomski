public void select(T item) {
   Guard guard = Guard.multi(theRealItemProperty.guard(), 
       theRealIndexProperty.guard());
   setIndex(indexOf(item));
   setItem(item);
   guard.close();
}