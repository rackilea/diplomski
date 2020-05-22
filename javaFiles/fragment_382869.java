SomeClass createObj(boolean setListener){

     SomeClass obj=new SomeClass();
     if (setListener){

        obj.setListener(this);
     }

     return obj;
}