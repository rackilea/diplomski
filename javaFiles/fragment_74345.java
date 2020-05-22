@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
inflater.inflate(R.menu.main, menu);
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
  switch (item.getItemId()) {
      case R.id.action_new1:

          Intent intent = new Intent( getActivity(), Login.class);
          getActivity().startActivity(intent);

          return true;
      default:
          return super.onOptionsItemSelected(item);
  }
}