@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);


    if (requestCode  == 0) { // Activity.RESULT_OK
       Toast.makeText(ContactUs.this, "Your message has been sent successfully.", Toast.LENGTH_SHORT).show();
    }

}