AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Create a Bicyclist Count Post");

        LinearLayout layout = new LinearLayout(context);

        LinearLayout.LayoutParams params = 
                new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setLayoutParams(params);

        final EditText input = new EditText(context);

        final EditText inputNotes = new EditText(context);

        //do your remaining stuff with input and inputNotes

        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        inputNotes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        layout.addView(input);
        layout.addView(inputNotes);


        alert.setView(layout);

        alert.show();