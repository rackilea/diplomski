private final Random r = new Random();
private final String[] magictext = {"yes", "no", "maybe"};
private TextView text;

protected void onCreate(Bundle savedInstanceState) {
    . . . // what you have now, followed by
    text = (TextView) findViewById(R.id.textView1);
}

public void magicbegins()
{
    int rand = r.nextInt(magictext.length);

    text.setText(magictext[rand]);
}