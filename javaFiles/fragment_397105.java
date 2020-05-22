class Test{
    static java.util.Random r=new java.util.Random();
    boolean test(){
        return r.nextBoolean();
    }
    void test1(){
        if (test() && test() && test())
            System.out.println("3x yes");
    }
    void test2(){
        if (test())
            if (test()) 
                if (test())
                    System.out.println("3x yes");
    }
}