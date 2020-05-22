if (!activityDestroyed) {
    dialog = new AlertDialog.Builder(Chat.this).setMessage("BLABLA")
            .setTitle("Invite!")  
            .setCancelable(true)  
            .setPositiveButton(android.R.string.ok,  
            new DialogInterface.OnClickListener() 
            {  
               public void onClick(DialogInterface dialog, int whichButton)
               {
                       dialog.cancel();
                       sendInvite();
               }  
            }) 
            .setNegativeButton(android.R.string.cancel,
            new DialogInterface.OnClickListener() 
            {  
               public void onClick(DialogInterface dialog, int whichButton)
               {
                       dialog.cancel();
               }  
            })
            .show();
}