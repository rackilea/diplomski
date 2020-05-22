try{
  List listA = supplier.getListA();
  List listB = supplier.getListB();
  Assert.sameSize( listA, listB );

  List listC = supplier.getListC();
  Assert.sameSize( listA, listC );
 }
catch(AssertionException ex){
  //error handling
}