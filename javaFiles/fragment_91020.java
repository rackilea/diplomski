final Handler h=new Handler();
h.postDelayed(new Runnable() {
   public void run() {
      printPrice(price);
      price = price + 0.05;
      h.postDelayed(this, 1000); // call for next update
   }
}, 1000);