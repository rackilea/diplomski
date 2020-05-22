class SpecificModifier extends IModParent{

      SpecificModifier(String nameTag){ this.nameTag = nameTag; }

      @Override
      public void foo(){ System.out.println(nameTag); }
   }