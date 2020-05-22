public class MainActivity extends Activity {

    private TableLayout tl;
    private Button clickTestRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = (TableLayout)findViewById(R.id.tableLayout1);
        clickTestRow = (Button) findViewById(R.id.clickTestRow);

        final TableRow[] row = new TableRow[5];
        final TextView tv[] = new TextView[5];
        final CheckBox[] cb = new CheckBox[5];

        for(int j = 0; j < 5; j ++){
            row[j] = new TableRow(this);
            tl.addView(row[j]);
            tv[j] = new TextView(this);
            cb[j] = new CheckBox(this);

            tv[j].setText("This is text");

            row[j].addView(cb[j]);
            row[j].addView(tv[j]);
        }
        cb[0].setChecked(true);

        clickTestRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 5; i ++){
                    if(cb[i].isChecked()){
                        tl.removeView(row[i]);
                    }
                }
            }
        });
    }
}