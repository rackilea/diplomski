private void resetToDefault() 
{       
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
    alertDialog.setTitle( getResources().getString(R.string.ram_bar_reset)); // <---- Changed Here
    alertDialog.setMessage( getResources().getString(R.string.progressbar_reset_message)); // <---- Changed Here
    alertDialog.setPositiveButton(getResources().getString(R.string.ok), // <---- Changed Here
                new DialogInterface.OnClickListener() 


    {           
    public void onClick(DialogInterface dialog, int id) 
    {
        ProgressBarColorReset();            
    }       
    });



    alertDialog.setNegativeButton(getResources().getString(R.string.cancel),// <---- Changed Here
                                     null);
    alertDialog.create().show();    
}