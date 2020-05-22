public void test1(){
   // not compiled or tested
   Assume.assumeThat(System.getProperty("java.version"), CoreMatchers.startsWith("1.5"));
   run();
}

public void test2(){
   Assume.assumeThat(System.getProperty("java.version"), CoreMatchers.startsWith("1.7"));
   run();
}