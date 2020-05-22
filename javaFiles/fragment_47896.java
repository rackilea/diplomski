public class LoginActivity1 extends Activity {

    Button btnLinkToRegistrScrn;
    Button loginbtn1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.login);
     addListenerOnButton();
        // Link to Register Screen 
        btnLinkToRegistrScrn = (Button) findViewById(R.id.LinkToRegisterScreen); 
        btnLinkToRegistrScrn.setOnClickListener(new View.OnClickListener() { 
           @Override
            public void onClick(View v) { 
                Intent i = new Intent(v.getContext(), TrekEyesAndroidActivity.class); 
              //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                } 
       }); 
   }
    public void addListenerOnButton() {

        //final Context context2 = this;

            loginbtn1 = (Button) findViewById(R.id.btnLogin);

            loginbtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(arg0.getContext(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                         startActivity(intent);   
            }

        });
    }
   }