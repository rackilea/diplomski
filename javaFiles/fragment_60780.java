@Override
public boolean onPrepareOptionsMenu(Menu menu) {
  MenuItem item = menu.findItem(R.id.bedSwitch);
    if (item.getTitle().equals("Set to 'In bed'")) {
        item.setTitle("Set to 'Out of bed'");
        inBed = false;
    } else {
        item.setTitle("Set to 'In bed'");
        inBed = true;
    }
  return super.onPrepareOptionsMenu(menu);
}