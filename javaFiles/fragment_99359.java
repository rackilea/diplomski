NType myAnotherType = Javonet.getType("MyAnotherType");
    NType myOtherType = Javonet.getType("MyOtherType");
    NType mySubType = Javonet.getType("MySubType");
    NType myType = Javonet.getType("MyType`1",mySubType);
    NType func = Javonet.getType("Func`3",myType,myOtherType,myAnotherType);

    NObject objA = Javonet.New("ObjA");
    objA.invoke("MethodA",new NNull(func),0);