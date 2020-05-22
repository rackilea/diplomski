Intent data = new Intent();
        data.putExtra("file", filename);

    if (getParent() == null) {
    setResult(Activity.RESULT_OK, data);
    } else {
   getParent().setResult(Activity.RESULT_OK, data);
    }
    finish();