for (int i = 0; i < X; i++) {
        final int index = i;
        threadPool.submit(new Runnable() {
             public void run() {

                  Function_to_run(index);

         }
     });