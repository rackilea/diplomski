int counter = 0;
button.setOnClickListener(new OnClickListener() 
{

    public void onClick(View v) 
    {
        counter++;
        button.setText("Amount" + counter + "x"); 
    }
});