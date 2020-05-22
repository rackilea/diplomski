@Override
public void onCreate(Bundle savedInstanceState) {
  Bundle bundle = getIntent().getBundleExtra("Name of extra"); // If that was a bundle
  YourType type = (YourType)getIntent().getSerializableExtra("Name of extra"); // If that was a serializable object
  // Etc...
}