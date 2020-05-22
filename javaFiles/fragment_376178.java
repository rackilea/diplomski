s=new Screen();
try{
    loadpics();
    s.setFullScreen(dm,this);
    Timer timer = new Timer(10000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            s.restoreScreen();
        }
    });
    timer.setRepeats(false);
    timer.start();
}catch(Exception e){
    e.printStackTrace();
}