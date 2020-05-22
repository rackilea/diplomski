class ClassA {
       private int a;

       public void setA() {
        a = 15;
        System.out.println(a);
       }
     }

      class ClassB extends ClassA {
          public static void main( String[] args ) throws IllegalAccessException, InstantiationException {
               Class cls = ClassB.class;
               ClassB obj = (ClassB) cls.newInstance();
               obj.setA(); //Accessible
               obj.test(); // Accessible

            }
           public void test() {
              setA();
           }
         }