new Thread( new Task<Void>() 
        {
            @Override
            public Void call() throws Exception // This is NOT on FX thread 
            {
                Thread.sleep(100);
                return null;
            }

            @Override
            public void succeeded()  // This is called on FX thread.
            {
                secondNode.requestFocus();
            }

        }).start();