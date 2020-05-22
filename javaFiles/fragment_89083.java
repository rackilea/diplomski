public void onCreate(Bundle savedInstanceState)
{
    //...other code here
    while (counter <5)
    {
        for (int i = 0; i < players; i++)
        {
            TextView name1 = (TextView) findViewById(R.id.pname);
            name1.setText( names[i]+":");

            ptasks = 10;
            rindex = generator.nextInt(ptasks);

            TextView task = (TextView) findViewById(R.id.task);
            task.setText( tasks[rindex]);

            Button failButton = (Button) findViewById(R.id.fail_btn);
            failButton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View failed)
                {
                    return;
                }
            });

            Button notButton = (Button) findViewById(R.id.notbad_btn);
            notButton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View notbad)
                {
                    return;
                }
            });

            Button champButton = (Button) findViewById(R.id.champ_btn);
            champButton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View champp)
                {
                    return;
                }
            });

        }

        counter++;
    }
    //...other code here
}