AlertDialog.Builder alertDialog = new AlertDialog.Builder(AlertDialogActivity.this);

    // Setting Dialog Title
    alertDialog.setTitle(R.string.creating_pdf);

    // Setting Dialog Message
    alertDialog.setMessage("File Name: " + file.getName() +"\nFile Path: " + filePath + "\nFile Size: " + fileSize/(1000*1000) + " Mb\nFile Created On: " + dateCreated);


    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int which) {

        }
    });


    alertDialog.setNegativeButton("Fix Date", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {


        }
    });

    // Showing Alert Message
    alertDialog.show();