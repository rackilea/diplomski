public class example{
    int activeButtons = 16;

    public void onCreate(Bundle savedInstanceState){
        //initialize
    }

    /**
    * This is your onClick method
    */
    public void click(View v){
        v.setEnabled(false);
        activeButtons--;
        if(activeButtons == 0){
            enable();
        }
    }

    /**
    * This will enable your four buttons
    */
    public void enable(){
        //Get references to your buttons here
        Button b1 = ...;
        Button b2 = ...;
        Button b3 = ...;
        Button b4 = ...;

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
   }
}