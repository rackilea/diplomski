public void saveB(B b) //"Child relationship"
{
  A a = b.getA();//do null checks as needed and get a reference to the parent
  a.getBs().add(b); //I've had the collection be null
  //Persistence here
  entityInstance.merge(a); // or persist this will cascade and use b
}

public void saveA(A a)
{
  //Persistence
  entityInstance.merge(a) // or persist
}