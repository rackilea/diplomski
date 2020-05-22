new Thread(){
        public void run(){
                for(int i=0; i<101; i++){                   
            try {
                Thread.sleep(40);
                jProgressBar1.setValue(i);
                if(i==20){//for checking 20% 
                   jLabel1.setText("Wait...it's still loading");
                }
            } catch (InterruptedException ex) {
              Logger.getLogger(Carregando.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
    }.start();