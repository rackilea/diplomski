Button OpenChannel = (Button)findViewById(R.id.OpenChannelMode0);

    OpenChannel.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if(radiobuttonObj1.isChecked()){
                //open activity 1
            }else if(radiobuttonObj2.isChecked()){
                //open activity 2
            }

        }
    });