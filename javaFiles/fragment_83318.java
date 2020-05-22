int doSomething(int myParameter)
{
  MyObject working_set = new MyObject();
  interim = working_set.doSomethingElse(myParameter);
  another_interim = doSomethingSneaky(working_set);
  return working_set.doSomethingElseAgain(another_interim);
}