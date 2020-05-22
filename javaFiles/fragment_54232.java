public class MainActivity<i> extends AppCompatActivity {
    private static final List nameArr = new ArrayList<Object>();
    //input textbox
    private EditText stuff;


    // Add player names and scores to the list
    private ListView score_lv;
    //Append
    private ArrayAdapter<String> arrayAdapter1;

    //Clear Scores button
    private Button updateButton;

    private static final String fileName = "scores";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        stuff  = (EditText)findViewById(R.id.editText);
        score_lv  = (ListView) findViewById(R.id.theList);
        arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameArr);

        nameArr.clear();
        nameArr.add(readFile(fileName));
        score_lv.setAdapter(arrayAdapter1);

        //button to update the ListView
        updateButton  = (Button) findViewById(R.id.addButton);
        updateButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                                                //write data to the internal phone app File
                        try{
                            FileOutputStream fileOS = openFileOutput(fileName, MODE_APPEND);
                            OutputStreamWriter osw = new OutputStreamWriter(fileOS);
                            try{
                                osw.write("\n");
                                osw.write(stuff.getText().toString());
                                osw.flush();
                                osw.close();
                                Toast.makeText(getBaseContext(),"Scores Saved to "+getFilesDir() + "/", Toast.LENGTH_LONG).show();
                            }catch(IOException e){
                                e.printStackTrace();
                            }
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }


                        //read data from Saved File to update the ListView with ALL items from the file
                        nameArr.clear();
                        nameArr.add(readFile(fileName));
                        score_lv.setAdapter(arrayAdapter1);
                    }
                });

        //button to go to the next Activity
        final Button nextAct = (Button) findViewById(R.id.toNext);
        nextAct.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent j = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(j);
                    }
                }
        );

        //delete file and clear ListView button
        final Button clearB = (Button) findViewById(R.id.clearButton);
        clearB.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        deleteFile(fileName);
                        Toast.makeText(getBaseContext(), "List Cleared", Toast.LENGTH_LONG).show();
                        //clear list
                        score_lv.setAdapter(null);
                    }
                }
        );
    }

    //as soon as this Activity starts, we read from the Output File
    public String readFile(String file){
        StringBuilder text = new StringBuilder();
        try{
            FileInputStream fis = openFileInput(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;

            while((line = reader.readLine()) != null){
                text.append(line);
                text.append('\n');
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"Error reading file!",Toast.LENGTH_LONG).show();
        }
        return text.toString();
    }