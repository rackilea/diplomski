public interface DialogCallback{

    void clickedPositiveStart();
    void clickedPositiveStop();
    void clickedNegativeStart();
    void clickedNegativeStop();
}




public class MyAdapter extends Adapter implements DialogCallback, View.OnClickListener{

   @Override
   protected void onClick(View view){
       DialogFragment newFragment =  null;
       String action;

       if(view.getId() == R.id.your_start_button){ 
           action = "start";
       }else if(view.getId() == R.id.your_stop_button){
           action = "stop";    
       }else if(..){
           ....
       }else{
           return;
       }

       newFragment = ConfirmationDialog.newInstance(TITLE,CONTENT, this, action);
       newFragment.show(((AppCompatActivity)contextView).getSupportFragmentManager(), TAG); 
   }

   @Override
   public void clickedPositiveStart(){
        // do something when positive is clicked
   }

   @Override
   public void clickedPositiveStop(){
        // do something when positive is clicked
   }

   @Override
   public void clickedNegativeStart(){
        // do something when negative is clicked
   }

   @Override
   public void clickedNegativeStop(){
        // do something when negative is clicked
   }

}


public ConfirmationDialog extends Dialogfragment{

    private DialogCallback callback;
    private String action;

    public static ConfirmationDialog newInstance(String title, String description, DialogCallback callback, String action) {
        this.callback = callback;
        this.action = action;
        ...
    }


@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    String title = getArguments().getString("title");
    String description = getArguments().getString("description");
    return new AlertDialog.Builder(getActivity())
            //.setIcon(R.drawable.alert_dialog_icon)
            .setTitle(title)
            .setMessage(description)
            .setPositiveButton("CONTINUE",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                           if(action.equals("start"){
                              callback.clickedPositiveStart();
                           } else if(action.equals("stop"){
                              callback.clickedPositiveStop();
                           }
                        }
                    }
            )
            .setNegativeButton("CANCEL",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                           if(action.equals("start"){
                              callback.clickedNegativeStart();
                           } else if(action.equals("stop"){
                              callback.clickedNegativeStop();
                           }
                        }
                    }
            )
            .create();
     }
 }

}