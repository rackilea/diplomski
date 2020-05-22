int selectedId = rg.getCheckedRadioButtonId();
    if (selectedId == -1)
    {
        //if the password less than 8 or more than 10
        AlertDialog.Builder alertBuilder3=new AlertDialog.Builder(MemberExercise.this);
        alertBuilder3.setTitle("Invalid");
        alertBuilder3.setMessage("Please select an answer first, then click on done.");
        alertBuilder3.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });

        alertBuilder3.create().show();
        return;
    }

    // find the radiobutton by returned id
    rbtn = (RadioButton) findViewById(selectedId);
    String selected = rbtn.getText().toString();