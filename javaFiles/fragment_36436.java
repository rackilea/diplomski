textView.postDelayed(new Runnable() {
       @Override
       public void run() {
            textView.setText(String.valueOf(++x));    
            textView.postDelayed(this, 100);
       }
  }, 100);