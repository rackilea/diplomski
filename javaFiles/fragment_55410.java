Bar bar;
if(foo!=null && (bar = foo.getBar())!=null){
  System.out.println("Success: " + bar);
} else {
  System.out.println("Failiure.");
}