protected void onActivityResult (int requestCode, int resultCode, Intent data)
{
    if (requestCode == 3) // here you match the number you sent in startActivityForResult
        if (resultcode == RESULT_OK)
             // do something
}