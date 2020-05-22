Timer timer = new Timer(delay,new ActionListener(){

        int spaces=0;

        public void actionPerformed(ActionEvent e) {
            String title="";
            for (int j = 0; j < spaces; j++) {
                title+= " " ;
            }
            title+= "Annoying";
            Main.this.setTitle(title);
            spaces=(spaces+1)%50;

        }}
    );
    timer.start();