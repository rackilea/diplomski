@Override
public void onListItemClick(ListView l, View v, int position, long id) {
    Intent intent = new Intent(getActivity(), ProfilePage.class);
    intent.putExtra("match_detail_id", aList.get(position).get(TAG_MATCH_ID));
    startActivity(intent);
}