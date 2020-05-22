// Get passing data from bundle
Bundle bundle = this.getArguments();
if (bundle != null) {
  UUID crimeID = (UUID) bundle.getSerializableExtra(EXTRA_CRIME_ID);
  // Do something with your CrimeID
  } else {
   Log.d(TAG, "UUID Data not found!");
}