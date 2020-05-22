String str = "method(public, static, void) main(String[] args){";

String[] parts = str.split("\\)");

System.out.println(parts[0]);  // method(public, static, void
System.out.println(parts[1]);  // main(String[] args