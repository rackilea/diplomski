CheckBox cBox = (CheckBox) findViewById(R.id.c_avl);
 findViewById(R.id.layoutavailable).setOnClickListener(new OnClickListener() {             
      @Override
      public void onClick(View v) {
          cBox.setChecked(!cBox.isChecked());                
      }
    });