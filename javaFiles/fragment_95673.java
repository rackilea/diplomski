method b(List aList){
  aList.add(new Object());
}

method c(List aList){
  aList=new ArrayList ();
  aList.add(new Object());
}


List a=new ArrayList();
b(a); -> it will add an object to a;
c(a); -> it will not add an object to a or modify it in any way