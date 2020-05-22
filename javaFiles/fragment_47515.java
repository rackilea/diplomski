@Stateless
class FirstBean implement IFirstBean
{
   ISecondBean secondBean;

   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   void firstPartOfmethod1()
   {
      //...
   }
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   void secondPartOfmethod1()
   {
      //...
   }
}

@Stateless
class SecondBean implement ISecondBean
{
   @TransactionAttribute(TransactionAttributeType.NEVER)
   void method2()
   {
      //....
   }
}   
@Stateless
class MainBean implement ISecondBean
{
   @TransactionAttribute(TransactionAttributeType.NEVER)
   void mainMethod()
   {
      firstBean.firstPartOfMethod1();
      secondBean.method2();
      firstBean.secondPartOfMethod1();
      //....
   }
}