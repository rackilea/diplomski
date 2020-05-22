public void a() {
  System.out.println(">> before b()");
  b();
  System.out.println("<< after b()");
}

public void b() {
  System.out.println(">>>> in b() <<<<");
}