class Super {
    protected void m() { ... }
  }
  class Middle extends Super {
  }
  class Sub extends Middle {
    public void m() { ... }
  }