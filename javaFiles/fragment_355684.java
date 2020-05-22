public class MyActivity extends Activity implements OnGenericMotionListener {

            @Override
            public void onCreate(Bundle savedInstanceState)
            {
               super.onCreate(savedInstanceState);

               TextView myView = new TextView(this);

               myView.setOnGenericMotionListener(this);
            }

            @Override
            public boolean onGenericMotion(View view, MotionEvent event) {


               return false;
            }

     }