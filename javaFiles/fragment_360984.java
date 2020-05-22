Bundle gotData = getIntent().getExtras();
if(gotData != null)
{
    GotPass = gotData.getString("key!");
    GotUname = gotData.getString("key!!");
}