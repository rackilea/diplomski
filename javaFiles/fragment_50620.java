@Override
public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
    compte selectedItem = m_adapter.getItem(position);

    Intent intent = new Intent(MainActivity.this, ActivityToStart.class);
    intent.putExtra("numcpt", selectedItem.numcpt);
    intent.putExtra("solde", selectedItem.solde);

    startActivity(intent);

}