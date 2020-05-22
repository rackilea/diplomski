public class NL extends Activity {



     public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
          Button b1=(Button)findViewById(R.id.Button01);
          Button b2=(Button)findViewById(R.id.Button02);
          b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(NL.this,Button1.class);
                startActivity(myintent2);

            }
        });
          b2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent myintent2 = new Intent(NL.this,Button2.class);
                    startActivity(myintent2);

                }
            }); 
    }
}