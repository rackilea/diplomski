public void createAlertDialog(){    
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.custom_dialog);
    dialog.setTitle("Message");
    Button continueButton = (Button) dialog.findViewById(R.id.dialogContinueButton);
    TextView tw = (TextView) dialog.findViewById(R.id.dialogText);
    Button finishButton = (Button) dialog.findViewById(R.id.dialogFinishButton);

    tw.setText("Message");
    continueButton.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
            dialog.dismiss();
            boolean connection = checkNetworkConnection();
            if(!connection){
                dialog.show();
            }
            else{
               prepareConnection();
            }
        }   
    });