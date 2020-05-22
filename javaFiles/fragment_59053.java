@Override
    public void onItemClick(AdapterView<?> parent, View view, int 
         position, long id) {

        item= (Hotel) parent.getItemAtPosition(position);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle("Your Title");
        dialog.setMessage("Your Message" );
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int id) {
            String names = item.getName();
            Intent i= new Intent(HotelList.this,UserViewActivity.class);
            i.putExtra("names",names);
            startActivity(i);
            alert.cancel();
          }
        })
        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() 
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            alert.cancel();
            }
        });

        final AlertDialog alert = dialog.create();
        alert.show();
    }

});