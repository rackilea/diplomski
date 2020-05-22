public class Main extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        // etc...
    }

    @Override
    public void onClick(View arg0)
    {
        switch (arg0.getId)
        {
            case btnOne:
                textView.append("1");
                break;
            case btnTwo:
                textView.append("2");
                break;
            case btnThree:
                textView.append("3");
                break;
            // etc...
        }
    }

}