Toast.makeText(ContactActivity.this, checkedcontacts,1000).show();
    Intent returnIntent = new Intent();
    returnIntent.putStringArrayListExtra("name",phno0);
    if (getParent() == null) {
        setResult(Activity.RESULT_OK, returnIntent);
    } else {
        getParent().setResult(Activity.RESULT_OK, returnIntent);
    }
    finish();