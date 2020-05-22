public class MainActivity extends Activity {

    LinearLayout linear1,linear2;
    ImageView imgArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        imgArrow = (ImageView) findViewById(R.id.imgArrow);

        linear1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(linear2.getVisibility() == View.GONE){
                    linear2.setVisibility(View.VISIBLE);
                    imgArrow.setImageResource(R.drawable.up);
                }else{
                    linear2.setVisibility(View.GONE);
                    imgArrow.setImageResource(R.drawable.down);
                }
            }
        });
    }
}