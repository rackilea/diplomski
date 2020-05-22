volatile boolean task1Running = false;

Runnable task1 = () -> {
     if(task1Running)
          return; //already running, exit

     task1Running = true;
     //handle task
     task1Running = false;
};