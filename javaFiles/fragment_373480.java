for (int i = 0; i < 10; i++){
   final int j = i;
   SomeClass something = new SomeClass();
   something.setOnClickListener(new OnClickListener() {
      public void onClick(){
         doSomething(j);
      }
   });
}