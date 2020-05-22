@Override
protected void onListItemClick(ListView l, View v, int position, long id)
{
    super.onListItemClick(l, v, position, id);
    try
    {
        Intent firstIntent = new Intent(Menu.this, CoverSheet.class);
        firstIntent.putExtra(EXTRA_PICTURE, images[position]);
        startActivity(firstIntent);
    }
    catch (Exception e)
    {
        Log.e("SAMPLE", "Exception ", e);
    }
}