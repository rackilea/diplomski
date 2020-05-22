List<A> myList = getMyList();

A foo= a(myList);

if (foo instanceof B) {
  B bar = (B)foo;
  System.out.println(bar.getName());
}