AlertDialog.Builder alertDialog=new AlertDialog.Builder(MapsActivity.this);
        alertDialog.setTitle("Marker Title !");
        alertDialog.setMessage("Enter the title");
        final EditText editText=new EditText(MapsActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);


      alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            String name=editText.getText().toString();
                if (name.trim().compareTo("")==0) {
                    Toast.makeText(MapsActivity.this, "Enter the tile !", Toast.LENGTH_SHORT).show();
                }

                else{
     MarkerOptions options = new MarkerOptions()
        .position(latLng)
        .title(name);
                }
            }
        });
 alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();