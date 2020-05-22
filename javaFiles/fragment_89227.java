PSW.startWatch(MethodToWatch.B).invoke("123123123",
                                       new Runnable() {
                                             public void run() {
                                               b();
                                             }
                                       });