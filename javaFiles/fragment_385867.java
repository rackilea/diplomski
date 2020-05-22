@Override
public void onClick(DialogInterface dialogInterface, int i) {
    delete.removeValue();
    list.remove(i);
    arrayAdapter.notifyDataSetChanged();
    Toast.makeText(list_view.this, "Report deleted", Toast.LENGTH_SHORT).show();
}