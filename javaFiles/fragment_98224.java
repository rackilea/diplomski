Thread thr = new Thread(() -> {
                int count = 0;

                while(count < 2) { // Bad practice but just for the example.
                    if (count == 1 && authClass.reAuthenticate()) {
                        System.out.println("Reauthenticated.");

                        authClass.doStuff();
                    } else {
                        authClass.doStuff();
                    }

                    count++;
                }
            });