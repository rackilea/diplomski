private AlertDialog mDialog; 
private int mListRowPosition;
public ServiceAdapter(Context context, ArrayList<Service> services) {
    super(context, 0, services);
    this.services = services;

    //Create AlertDialog here
    AlertDialog.Builder builder = new AlertDialog.Builder(context); 
    builder.setMessage("Your Message")
           .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // Use mListRowPosition for clicked list row...
               }
           })
           .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // User cancelled the dialog
               }
           });
    // Create the AlertDialog object 

    mDialog = builder.create();
}