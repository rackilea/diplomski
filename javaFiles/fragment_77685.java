// OnCreate on Student Activity
@Override
protected void onCreate(Bundle savedInstanceState)
{
    ...
    Bundle extras = getIntent().getExtras();

    if (extras != null)
    {
        String schoolName = extras.getString("schoolName");
    }

    // Then filter the students by [schoolName] and then add the result to the student array used by the student adapter and then notify the student listview.

    ...
}