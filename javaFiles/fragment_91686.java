int[] step = {100,200,300,400,500};
System.out.print("$> processed < ");
for (int i : step) {
   System.out.print(i + " > records.\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
   Thread.sleep(500);
}