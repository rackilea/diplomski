class Parent{

    void m1(){
        System.out.println("Parent : m1");
        m2impl();
    }
    private void m2impl() { /* whatever */ }

    void m2(){
        m2impl();
    }
}