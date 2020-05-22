String x = "Foo";

public void change (String s) {
   s="Bar";
}

System.out.println(x);
change(x);
System.out.println(x);