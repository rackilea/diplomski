public void onCreate(Bundle savedInstanceState)
{
    //...other code here
    int i = 0;
    TextView name1 = (TextView) findViewById(R.id.pname);
    TextView task = (TextView) findViewById(R.id.task);        

    Button failButton = (Button) findViewById(R.id.fail_btn);
    failButton.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View failed)
        {
            //do what must be done for the current player, calculate score, etc
            prepareNextPlayer(++i, names, name1, task);
        }
    });

    Button notButton = (Button) findViewById(R.id.notbad_btn);
    notButton.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View notbad)
        {
            //do what must be done for the current player, calculate score, etc
            prepareNextPlayer(++i, names, name1, task);
        }
    });

    Button champButton = (Button) findViewById(R.id.champ_btn);
    champButton.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View champp)
        {
            //do what must be done for the current player, calculate score, etc
            prepareNextPlayer(++i, names, name1, task);
        }
    });
    //...other code here
}

private void prepareNextPlayer(int i, ArrayList<String> names, String [] tasks, TextView nameField, TextView taskField)
{
        if(i >= names.size())
        {
            //all players have been processed, what happens now?
            return;
        }

        int rindex = generator.nextInt(10);
        nameField.setText( names.get(i)+":");
        task.setText( tasks[rindex]);
}