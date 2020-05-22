@Override public void keyPressed(KeyEvent e) {
    if (timer == true && System.currentTimeMillis() - lastTimer < 200) {
      if(e.keyCode >=48 && e.keyCode <=57) { //number pressed
          lastTimer = System.currentTimeMillis();
          myString = myString + Character.toString(e.character);
        }
        if(e.keyCode == SWT.CR) {
          myString = signsToNumbers(myString);
          newUrl = browser.getUrl()+ "/newcode/" + myString;
          browser.setUrl(newUrl);
          text.setText(newUrl);
          System.out.println(myString);
          System.out.println("barcode read");
          myString = "";
          timer = false;
          lastTimer = 0;
        }
    }else{
        if(e.keyCode >=48 && e.keyCode <=57) {
          lastTimer = System.currentTimeMillis();
          timer = true;
          myString = Character.toString(e.character);
        }
        myString = "";
        lastTimer = 0;
    }        
  }
});