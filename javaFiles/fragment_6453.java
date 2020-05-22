private void processGallery() {
 adapter = new MyAdapter(this, containers, appName);
 if (adapter != null) {
  gallery.setAdapter(adapter);
 }
}

@Override
public void onItemClick(final AdapterView<?> adapterView, final View view, final int position, final long id) {
 if (containers != null) {
  container = containers.get(position);
  if (container != null) {
   // Handle selected image
  }
 }
}