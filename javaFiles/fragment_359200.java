public void testIt() throws Exception{
    A a = new A();
    set("setName", "xyz", a);
    String name = (String) get("getName",a);
    System.out.println(name);
}