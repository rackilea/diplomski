int doSomething(int myParameter)
{
  MyObject working_set = new MyObject();
  interim = working_set.doSomethingElse(myParameter);
  return working_set.doSomethingElseAgain(interim);
}