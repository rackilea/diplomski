new Timer().scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
    if (items.size() > 0) {
      for (int i = 0; i < items.size(); i++) {
        displayText.setText(displayText.getText().toString() + "\n" + items.get(i)); 
      }
    } else {}
  }
},0,1000);