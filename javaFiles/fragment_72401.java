Bundle extras = getIntent().getExtras();

if(extras == null) 
{
    //not being clicked on
} 
else if (extras.getBoolean("NotiClick"))
{
    //being clicked
}