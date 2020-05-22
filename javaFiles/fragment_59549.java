@Override
    public void onClick(DialogInterface arg0, int arg1) {
        // TODO Auto-generated method stub

        switch(arg1)
        {
            case DialogInterface.BUTTON_POSITIVE:
                //take text from dialog fields and show all info on MainActivity
                //these are changes
                title = gTitle.getText().toString(); 
                caption = gCaption.getText().toString();

                tvTitle.setText(title);
                tvCaption.setText(caption);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "You cancelled dialog entry", 300).show();
                break;
        }

    }