public class letterms extends AppCompatActivity {

    String[] mArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letterms);

        int length =0;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        length =getResources().getStringArray(R.array.let_terms).length;

        mArray = getResources().getStringArray(R.array.let_terms);

        final LinearLayout verticalLayout= LinearLayout)findViewById(R.id.buttonlayout);

        int verticalWidth = verticalLayout.getWidth();
        int numberOfButtonsPerLine = (verticalWidth/buttonWidth);
        int numberOfLines = (length/numberOfButtonsPerLine) + 1;

        for(int i=0;i<length;){
          LinearLayout newLine = new LinearLayout(this);
          newLine.setLayoutParams(params);
          newLine.setOrientation(LinearLayout.HORIZONTAL);
          for(int j=0;j<numberOfLines;j++){

            final String nazv = mArray[i];
            final String[] splittedItem = nazv.split(":");

                Button button=new Button(this);
                button.setId(i);
                button.setWidth(20);
                button.setLayoutParams(params);
                button.setText(splittedItem[0]);
                button.setTextColor(0xFF2C85A6);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        Intent is = new Intent(getApplicationContext(), termin_full.class);
                        is.putExtra("fVariableName", nazv);
                        startActivity(is);
                    }
                });

                newLine.addView(button);
                i++;
                if(i>=length) {
                   break;
                }
          }
          verticalLayout.addView(newLine);

        }

    }
}