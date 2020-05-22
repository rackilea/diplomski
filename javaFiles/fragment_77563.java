// Showing inference at work
List<Integer> a = Arrays.asList(10, 20, 30);  // (5)
T is inferred to be ? extends Object
Method signature: ppp(? extends Object, List<? extends Object>)
Method call signature: ppp(String, List<Integer>);
ppp("Hello", a); // ok