@override
public bool onPrepareOptionsMenu(Menu menu)
{
    super.onPrepareOptionsMenu(menu);
    MenuItem m  = memenu.findItem(R.id.YourItemId);
    m.setChecked(!m.isChecked());//something like this

    return true;
}