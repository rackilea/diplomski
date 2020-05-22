while (in.hasNextDouble()) {
    double current = in.nextDouble();
    sum = sum + current;
    count++;

   if (current > max) {
       max = current;
   }
   if (min > current) {
       min = current;
   }
}