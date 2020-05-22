@Inject
   private Instance<MYType> myTypeInst;

   // This will ensure, that the bean is always fresh created.
   // But the property value on the former instance will be lost
   // So the changable value has to be provided another way to the created bean
   public void do SomeThing(){
      MyType bean = myTypeInst.get();

      myTypeInst.destroy(bean);
   }
}