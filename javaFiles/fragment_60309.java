public class MyActivity ..... {

     EditText something;
     AnyFragment frag;

     public MyActivity(){
         frag = new AnyFragment();
         frag.setFragListener(new AnyFragment.FragListener() {
             @Override
             public void notifyActivity(String text) {
                 setText(text);
             }
         });
     }

     public void setText(String text){
         something.setText(text);
     }
}

public class AnyFragment extends DialogFragment implements AnyListener{

    private FragListener listener;

    public setFragListener(FragListener listener) {
        this.listener = listener;
    }

    public void onEvent(String text){
        if(listener != null)
            listener.notifyActivity(text);
    }

    public interface FragListener {
        void notifyActivity(String text);
    }
}