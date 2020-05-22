interface FunctionInterface {
  float bar(int x);
}

FunctionInterface foo() {
  return new FunctionInterface() {

    @Override
    public float bar(int x) {
      return x;
    }

  };
}