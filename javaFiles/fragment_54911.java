public static void main(String args[]) {
   Number n = Integer.valueOf(66); // Autoboxing

   incr((Integer) n);

   System.out.println(n);
}