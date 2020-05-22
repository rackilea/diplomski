public class Example extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        OnClickListener listener = new OnClickListener() {
            public void onClick(View view) {
                TextView text = (TextView) view.getTag();

                if(((Button) view).getText().equals("+"))
                    text.setText(Integer.parseInt(text.getText().toString()) + 1 + "");
                else
                    text.setText(Integer.parseInt(text.getText().toString()) - 1 + "");
            }
        };

        for(int i = 0; i < 5; i++) {
            LinearLayout line = new LinearLayout(this);
            line.setOrientation(LinearLayout.HORIZONTAL);

            TextView text = new TextView(this);
            text.setText(i + "");
            line.addView(text);

            Button plus = new Button(this);
            plus.setTag(text);
            plus.setText("+");
            plus.setOnClickListener(listener);
            line.addView(plus);

            Button minus = new Button(this);
            minus.setTag(text);
            minus.setText("-");
            minus.setOnClickListener(listener);
            line.addView(minus);

            layout.addView(line);
        }

        setContentView(layout);
    }
}