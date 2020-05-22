public void performActionAsync(){
    new Thread(new Runnable(){
        @Override
        public void run(){
           performAction();
        }
    }).start();
}

private void performAction(){
    //perform actions as normal
}