Thread t = new Thread(){
                public void run(){
                    while( true ){
                        // queue on Event Dispatch Thread
                        SwingUtilities.invokeLater( new Runnable(){
                            public void run(){
                                barrel.move();
                                repaint();
                            }
                        });
                        try{
                            Thread.sleep( 100 );
                        }catch( InterruptedException ie ){}
                    }
                }
            };
            t.start();