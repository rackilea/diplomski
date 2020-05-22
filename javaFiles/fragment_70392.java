Thread thread = new Thread() {

            public void run () {
                 try
                { 
                     pg.show();
                     //long running task
                 }
                catch(){
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        //code for Update UI  after the long running  task


                        // dismiss the progress dialog on UI thread
                        pg.dismiss();

                    }
                });

            }
        };

        thread.start();