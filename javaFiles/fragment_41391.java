button[1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { 
       Thread worker = new Thread(new Runable(){
           public void run(){
              button[1].setIcon(elemek[1]);
              p+=1;
              g[0]=t[1];
              Thread.sleep(1000);
              //dosomething
           }});
        worker.start();

    }});