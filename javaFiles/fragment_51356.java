protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
    case CHILD_CODE:
        if (resultCode == Activity.RESULT_OK) {
            yourMethod();
        }
    }
}