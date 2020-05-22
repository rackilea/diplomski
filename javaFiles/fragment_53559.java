private Button   mButton;
private EditText mEdit;
private EditText mEdit1;
private EditText mEdit2;
private TextView mText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mButton = (Button)findViewById(R.id.button2);
    mEdit   = (EditText)findViewById(R.id.editText);
    mEdit1   = (EditText)findViewById(R.id.editText2);
    mEdit2   = (EditText)findViewById(R.id.editText3);
    mText = (TextView)findViewById(R.id.textView4);

    mButton.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    //Int definēšana
                    int i1 = Integer.parseInt(mEdit.getText().toString());
                    int i2 = Integer.parseInt(mEdit1.getText().toString());
                    int i3 = Integer.parseInt(mEdit2.getText().toString());

                    //Mainīgo ievade
                    int a = i1;
                    //Pārbauda vai a nav nulle
                    if (a == 0){
                        mText.setText(String.valueOf("Nav kvadrātvienādojums"));
                    } else {
                        int b = i2;
                        int c = i3;

                        //Diskriminanta aprēķināšana
                        double diskr = (b*b)-4*a*c;
                        //Kvadrātsakne no diskriminanta
                        double sd = (double) Math.sqrt(diskr);
                        //Sakņu aprēķināšana
                        double x1 = (-b+sd)/(2*a);
                        double x2 = (-b-sd)/(2*a);

                        //Rezultāta izvade
                        if (diskr < 0){
                            mText.setText(String.valueOf("Kvadrātvienādojumam nav sakņu"));
                        } else if (diskr == 0){
                            mText.setText(String.valueOf("Kvadrātvienādojumam ir viena sakne: " + x1));
                        } else {
                            mText.setText(String.valueOf("Kvadrātvienādojuma saknes: " + x1 + " un " + x2));
                        }
                    }
                }
            });
}