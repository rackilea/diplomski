@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    if (spinner5.getSelectedItem().toString().equals("Other")) {
        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);
    }
}