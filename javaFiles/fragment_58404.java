private Button.OnClickListener btnSendListener = new Button.OnClickListener(){


@Override
public void onClick(View view) {

    switch (view.getId()){

        case R.id.btnSend:
            int selectedId = rgdSize.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        int selectedId2 = rgdRank.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton2 = (RadioButton) findViewById(selectedId2);

      String result = radioButton.getText()+""+radioButton2.getText();



           new AlertDialog.Builder(getActivity())
                    .setTitle("Please make sure you choose correct")
                    .setMessage(""+result)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    })

                    .setNegativeButton("CANCEL", new 
              DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    })
                    .show();

    }

    }

};