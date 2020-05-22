int count = 0;

String[] responses = new String[50];

left.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View v)
    {
        left.setImageResource(R.drawable.left);
        right.setImageResource(R.drawable.right);

        responses[count] = "Left";

        count++;

        if(count == 50)
        {
            // Exit the activity
        }
    }
};

right.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View v)
    {
        left.setImageResource(R.drawable.left);
        right.setImageResource(R.drawable.right);

        responses[count] = "Right";

        count++;

        if(count == 50)
        {
            // Exit the activity
        }
    }
};