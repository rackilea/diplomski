private void getRefereeProfile()
{
    Referee memberInfo = SQLiteFunctionUtility.getReferee(referee_id, mDbHelper.getSqliteObjectWithReadable());
    if (memberInfo != null)
    {
        txtview1.setText(memberInfo.getName());
        txtview2.setText(memberInfo.getGame1());
        txtview3.setText(memberInfo.getGame2());
        // what is txtView4 for?
    }
    else
    {
        Toast.makeText(MainActivity.this, "No Referee Found", Toast.LENGTH_LONG).show();
    }