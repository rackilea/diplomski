final boolean[] methodCalled = new boolean[1]; 
MyClass testTarget = new MyClass()
{
   void functionA(args)
  {
    methodCalled[0] = true;
  }

};

testTarget.function1(arg1, arg2, arg3);
//assert methodCalled[0] is true