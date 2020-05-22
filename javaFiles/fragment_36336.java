public class DialogWindow extends Activity{

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.dialog_window);

Button btn = (Button) findViewById(R.id.btn_dialog);
btn.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        createDialog.show();
    }
});
}

public Dialog createDialog() {
      //using the builder class
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setMessage("Simple Dialog")
         .setPositiveButton("nothing", new DialogInterface.OnClickListener() {

             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //getBaseContext() is not advised (I can't remember why right now but I know I read it. You may want to read more that method but for now getActivity will work for your Toast.
                 //Toast.makeText(getActivity(), "ok then", Toast.LENGTH_SHORT).show();
          }
          })
         .setNegativeButton("cancel", new DialogInterface.OnClickListener() {

             @Override
             public void onClick(DialogInterface dialog, int which) {
               //Toast.makeText(getActivity(), "cancel", Toast.LENGTH_SHORT).show();
            }
            });

            return builder.create();
     }
}