Button b_read;
TextView tv_text;
String name = "";
int height = 0;
int weight = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    b_read = (Button) findViewById(R.id.b_read);
    tv_text = (TextView) findViewById(R.id.tv_text);

    b_read.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(getAssets().open("test.txt")));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    text = text.concat(line + "\n");
                    String[] lineVals = line.split(":");
                    if(lineVals[0].equalsIgnoreCase("name")){
                        name = lineVals[1].trim();
                    } else if(lineVals[0].equalsIgnoreCase("height")){
                        height = Integer.parseInt(lineVals[1].trim());
                    } else if(lineVals[0].equalsIgnoreCase("weight")){
                        weight = Integer.parseInt(lineVals[1].trim());
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            tv_text.setText(text);
        }
    });
}