public class CustomDialogPreference extends DialogPreference implements DialogInterface.OnClickListener{

public CustomDialogPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    setPersistent(false);
    setDialogLayoutResource(R.layout.image_dialog);
    setPositiveButtonText("OK");
    setNegativeButtonText("CANCEL");
}

@Override
public void onClick(DialogInterface dialog, int which){
    if(which == DialogInterface.BUTTON_POSITIVE) {
        // do your stuff to handle positive button
    }else if(which == DialogInterface.BUTTON_NEGATIVE){
        // do your stuff to handle negative button
    }
 }
}