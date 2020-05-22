static final int PICK_CONTACT_REQUEST = 1;  // The request code
   ...
   private void pickContact() {
       Intent pickContactIntent = new Intent(Intent.ACTION_PICK, new Uri("content://contacts"));
       pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
       startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }