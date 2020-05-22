A  a = new C();
  a.printA(); // work

  B b = (B) a;
  b.printB(); // work

  C c = (C) b;
  c.printC(); // work