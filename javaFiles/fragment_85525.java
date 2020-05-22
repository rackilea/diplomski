btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        if(edt.getText().toString().equals("")){

        }
        else {
        Toast.makeText(view.getContext(),"Entered: "+edt.getText().toString(),Toast.LENGTH_SHORT).show();
        myStringArray[childPosition]=edt.getText().toString();
        edt.setText("");
        }
    }
});