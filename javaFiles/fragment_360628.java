public void test() {
    ComputerOrder co = new ComputerOrder();
    co.add(new ComputerPart()); //ok
    co.add(new Peripheral());   //ok
    co.add(new Service());      //ok

    co.add(new Cheese());  //compilation error
    co.add(new Fruit());  //compilation error
}