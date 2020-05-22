public class MyActivity ..... {

     EditText something;
     AnyFragment frag;

     public MyActivity(){
          frag = new AnyFragment(this);
     }

     public void setText(String text){
          something.setText(text);
     }
}

public class AnyFragment extends DialogFragment implements AnyListener{

     private Context context;

     public AnyFragment(Context context) {
         this.context = context;
     }

     public void onEvent(String text){
         ((MyActivity)context).setText(text);
     }
}