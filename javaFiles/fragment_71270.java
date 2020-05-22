Thread t = new Thread(){
        public void run(){
            while( true ){
                addRandomLine();
                repaint();
                // and as per the requiement: 
                try{
                    Thread.sleep( 1000 );
                }catch( InterruptedException ie ){}
            }
        }
    };