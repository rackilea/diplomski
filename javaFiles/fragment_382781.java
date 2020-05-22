next.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(validationSuccess()){
                            Intent intent = new Intent(ManagerQuestionnaire1.this, ManagerQuestionnaire2.class);
                            startActivity(intent);
                        }
                    }
                });

        private Boolean validationSuccess(){
    if(rg1.getCheckedRadioButtonId()==-1&&rg2.getCheckedRadioButtonId()==-1&&rg3.getCheckedRadioButtonId()==-1){
    alertDialog();
    return false;
    }


//optional to add whether to check which questn is not answered   

        if(mBtn1.isChecked()==false&&mBtn2.isChecked()==false&&mBtn3.isChecked()==false){
                    alertDialog();
                    return false;
                    }
                if(mBtn4.isChecked()==false&&mBtn5.isChecked()==false&&mBtn6.isChecked()==false){
                    alertDialog();
                    return false;
                    }
                if(mBtn7.isChecked()==false&&mBtn8.isChecked()==false&&mBtn9.isChecked()==false){
                    alertDialog();
                    return false;
                    }
    return true;    
            }




    private void alertDialog() {
AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
            ManagerQuestionnaire1.this);
    alertDialogBuilder.setMessage("Please ensure all Questions are answered")
            .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();


                }