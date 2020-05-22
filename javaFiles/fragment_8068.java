private void createSprites(int x) {
   new Thread(new Runnable() {
        public void run() {

            for(int i = 0; i < x; i++) {

            sprites.add(createSprite(R.drawable.image));
            try
                {
                Thread.sleep(1000); //Waits for 1 second
                }
            catch(InterruptedException e)
                {
                e.printStackTrace();
                }
            }
        }
    }).start();
}