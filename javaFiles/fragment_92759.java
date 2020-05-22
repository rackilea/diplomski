SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    Thread t=new Thread(new Runnable(){
                        MyClass c=new MyClass(file)
                        public void run(){
                          c.start(); 
                        }
                     }); 
                     t.start();      
                }
            });