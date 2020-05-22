void doSomeThingOnBasisOfClassName(Class c){
            System.out.println(c.getCanonicalName());
            if(c.getCanonicalName().equals("com.example.ZiggyTest2")){
                System.out.println("Do some thing");
            }
        }