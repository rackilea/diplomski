int i = 0;
while (i < 10) {
   i++;
   final int ii = i;
   executor.submit(new Runnable() {
           public void run() {
                 System.out.println(ii); // OK
           });
}