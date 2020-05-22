public MyBaseClass extends BaseClass { 
    @Override
    protected void protectedMethod(OtherObject object) {
        super.protectedMethod(object);
    }
 }

 public Child1 extends MyBaseClass { ... }
 public Child2 extends MyBaseClass { ... }