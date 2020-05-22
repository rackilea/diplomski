final java.swing.Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(counter>5) {
                timer.stop();
                <dispose the fram here>
            }else{
               counter++;
               }
        }
    });
    timer.start();