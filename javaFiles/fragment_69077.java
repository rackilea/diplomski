@Override
public boolean onPrepareOptionsMenu(final Menu menu) {

    MenuItem menuItem = menu.findItem(R.id.itemID);
    menuItem.setTitle(Integer.toString(scoreVal));
    return true;
}