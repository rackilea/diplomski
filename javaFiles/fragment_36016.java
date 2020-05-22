public void btn_own(View view) {
    int a, b, c;        // a : untere Grenze , b : obere Grenze


AlertDialog.Builder alert = new AlertDialog.Builder(this);

    alert.setTitle("Enter range");
     LinearLayout linearLayout = new LinearLayout(context);
     linearLayout.setOrientation(1);
     linearLayout.setGravity(Gravity.CENTER);


    final EditText inputa = new EditText(this);
    final EditText inputb = new EditText(this);
     linearLayout.addView(inputa );
     linearLayout.addView(inputb );

    alert.setView(linearLayout );


        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                int aa = 0;
                int bb = 0;
                int cc = 0;
                int e = 0;
                try {
                    aa = Integer.parseInt(inputa.getText().toString());
                }   catch (NumberFormatException f) {
                    System.out.println("not a number: " + inputa.getText().toString());
                    f.printStackTrace();
                }

                try {
                    bb = Integer.parseInt(inputb.getText().toString());
                }   catch (NumberFormatException g) {
                    System.out.println("not a number: " + inputb.getText().toString());
                    g.printStackTrace();
                }
                cc = bb - aa;
                Random rand = new Random();
                int d = rand.nextInt(cc);
                e = d + bb;
                Integer out = new Integer(e);
                s = out.toString();

                new AlertDialog.Builder(Decider.this)
                        .setMessage(s)
                        .show();

            }
        });
    alert.show();