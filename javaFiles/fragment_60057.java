public AlertDialog showallDialog()
    {
        final CharSequence[] items = {"Yes", "No", "Can't Say"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("AM I AWESOME?");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item)
            {
                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                //create your intent here
                Intent intent = new Intent(getApplicationContext(), YourNextActivity.class);
                startActivity(intent);
            }
        });
        return builder.create();
    }