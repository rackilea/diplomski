interface IFunc {
   void someFunction();
}
class Func1 implements IFunc
{
   void someFunction(){..}
}
class Func2 implements IFunc
{
   void someFunction(){..}
}
void getTheLateCall(IFunc func)
{
   func.someFunction();
}