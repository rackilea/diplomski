public Interface ThreadTask {
    void run();
}

ThreadTask[] tasks;

while (playing) {
   for (ThreadTask tt: tasks) {
       if (!playing) {
           break;
       }
       tt.run();
   }
}