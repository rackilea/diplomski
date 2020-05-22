//receiving activity
Intent recIntent = getIntent();
if (recIntent.getStringExtra("source") != null)
{
     String source = recIntent.getStringExtra("source");
    if (source.equals("activityName"))
    {
         // do stuff
    }
    if (source.equals("differentActivityName"))
    {
         // do other stuff
    }
}