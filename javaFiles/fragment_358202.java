AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the workout name");

        //Create the user input xml file into a java object; capturing the user input from the dialog box
        //inflate means "fill"
        View view = LayoutInflater.from(this).inflate(R.layout.userinput,null);
        final EditText mAddWorkout = (EditText)view.findViewById(R.id.workout_name_input);

        builder.setView(R.layout.userinput);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                boolean brkpt = true;
            }
        }); //Second parameter pass in which event listener should trigger when the button is clicked
        AlertDialog alertDialog = builder.create();
        alertDialog .show();
Button saveWorkout = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
    saveWorkout .setOnClickListener(new CustomClickListener(alertDialog));