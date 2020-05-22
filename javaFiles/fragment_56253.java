public class durood extends Activity{

         private TextView txtCount;
         private TextView totalCount;
         private EditText enteramount;
         private Button btnCount;
         private Button addtotal1;
         private Button addtotal2;
         private Button cleartotal;
         private static int count=0;
         private int x=0;
         private int y=0;
         private int z=0;

          @Override
           public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
            // The activity is being created.
            setContentView(R.layout.durood);

            enteramount = (EditText)findViewById(R.id.enteramount);
            totalCount = (TextView)findViewById(R.id.totalCount);
            addtotal1=(Button)findViewById(R.id.addtototal1);
            addtotal2=(Button)findViewById(R.id.addtototal2);


            //add to total 1
            addtotal1.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {

              x=Integer.parseInt(enteramount.getText().toString());
              y=Integer.parseInt(totalCount.getText().toString());
              z=x+y;
              totalCount.setText(Integer.toString(z));
              //to set value of enteramount to 0
              enteramount.setText("0"); //or enteramaount.setText("") if You want show nothing
            }


           });