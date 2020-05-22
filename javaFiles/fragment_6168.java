AlertDialog.Builder builderSingle = new AlertDialog.Builder(DialogActivity.this);
builderSingle.setIcon(R.drawable.ic_launcher);
builderSingle.setTitle("Select One Name:-");

final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DialogActivity.this, android.R.layout.select_dialog_singlechoice);
arrayAdapter.add("Hardik");
arrayAdapter.add("Archit");
arrayAdapter.add("Jignesh");
arrayAdapter.add("Umang");
arrayAdapter.add("Gatti");

builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(DialogActivity.this);
                builderInner.setMessage(strName);
                builderInner.setTitle("Your Selected Item is");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                dialog.dismiss();
                            }
                        });
                builderInner.show();
            }
        });
builderSingle.show();