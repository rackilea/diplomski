class Foo {

  void test() {
    int var = 3;

    class Inner {
        int var = 1;

        void print_var_of_test(int var) {
          System.out.println("outer var=" + var);
          System.out.println("inner var=" + this.var);
        }
    }

    Inner inner = new Inner();
    inner.print_var_of_test(var);
  }

}