try {
   // some stuff here
   throw new QueueT();
} catch (RuntimeException e) {
   System.out.print("<<"+e+">>");
}