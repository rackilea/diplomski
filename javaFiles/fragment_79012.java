int i = 0;
while (i < 10) {
   i++;
   executor.submit(new Runnable() {
           public void run() {
                System.out.println(i);  // Compilation Error
           });
}