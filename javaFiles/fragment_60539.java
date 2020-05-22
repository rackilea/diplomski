int requestCode1 = 1;
int requestCode2 = 2;
int requestCode3 = 3;

Button b1 =(Button) findViewById(R.id.button1);
Button b2 =(Button) findViewById(R.id.button2);
Button b3 =(Button) findViewById(R.id.button3);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialogRadio(requestCode1)

    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialogRadio(requestCode2)

    }
});
b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialogRadio(requestCode3)

    }
});



@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == requestCode1){}//button 1
    else if(resultCode == requestCode2){}//button 2
    else if(resultCode == requestCode3){}//button 3

}

public void AlertDialogRadio(final int requestCode) {
    final CharSequence[] ClaimsModel = {"Sunny", "Raining", "Cloudy"};

    AlertDialog.Builder alt_bld = new AlertDialog.Builder(getActivity());
    alt_bld.setTitle("Select Weather");
    alt_bld.setSingleChoiceItems(ClaimsModel, -1, new DialogInterface
            .OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
            if (item == 0) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Sunny.class);
                startActivityForResult(intent, requestCode);
            } else if (item == 1) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Rainy.class);
                startActivityForResult(intent, requestCode);
            } else if (item == 2) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Cloudy.class);
                startActivityForResult(intent, requestCode);
            }
        }
        dialog.dismiss();

    }
});
AlertDialog alert = alt_bld.create();
alert.show();