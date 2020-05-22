AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);
    String[] routes=getResources().getStringArray(R.array.bus_routes);
    String[] seleted_routes={routes[position]};
alertDialogBuilder.setItems(seleted_routes,
                                     new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                ///.. get clicked item here          
            }   
        });
    AlertDialog alertDialog = alertDialogBuilder.create();          
    alertDialog.show();