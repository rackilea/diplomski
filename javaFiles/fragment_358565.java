b1.setOnClickListener(new View.OnClickListener() {

    private boolean b = true;

    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        if(b){
            b2.setEnabled(false);
            tv1.setText("true");
        } else {
            b2.setEnabled(true);
            tv1.setText("false");
        }

        b = !b; //this changes b from true to false and vice versa at each call
    }
   });