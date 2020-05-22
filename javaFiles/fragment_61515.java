public class CustomActivity extends Activity {

     private AnotherClass mClass;

     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         mClass = new AnotherClass(this);
     }

     //Implement each method you want to use.
     public String getInfoFromOtherClass()
     {
        return mClass.getInfoFromOtherClass();
     }
 }