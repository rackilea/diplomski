public void onListItemClick(ListView l, View v, int position, long id)
{
    super.onListItemClick(l, v, position, id);

    list.remove(position);
    adapter.notifyDataSetChanged(); //Updates adapter to new changes
}