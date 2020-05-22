@Override
    public void onClick(View v) {
        switch(v.getId()){

          case R.id.pic2radioA:
               Intent iA2 = new Intent(this, Activity3.class);
               A2=A2+1;
               iA2.putExtra("A2",A2);
               startActivity(iA2);
               break;
      //same for the rest
     }}