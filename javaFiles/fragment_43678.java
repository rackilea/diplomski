void animateWithTimer(){

    new Timer(1000,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int newAngle = (model.getAngle() < 360 ) ? model.getAngle()+1 : 0 ;
            model.setAngle(newAngle);
            view.refresh();
        }
    }).start();
}