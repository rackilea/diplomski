ip = "";
        // start creating the dialog message
        builder = new AlertDialog.Builder(this);
        builder.setView(dialoglayout);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // get the editText from the dialog's view
                        EditText text = (EditText) dialoglayout
                                .findViewById(R.id.et_gamerIpOrWebAdress);
                        // disable all input views
                        ip = text.getText().toString();
                        if (!ip.equals(""))
                        {
                            new GamerWorker().execute(ip);

                            //refreshing GUI
                            intent = new Intent(MainActivity.this, BroadcastService.class);
                        }
                        //clear();
                        //myList.clear();   

                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // cancels the dialog
                        dialog.dismiss();
                    }
                });

        if (ip.equals("") && ip.isEmpty())
        {
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        else
        {
        // set the ip address
            //ip = "123.123.224.133";
            new GamerWorker().execute(ip);
            intent = new Intent(MainActivity.this, BroadcastService.class);
        }
    }