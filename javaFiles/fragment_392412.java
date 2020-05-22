final static int REQUEST_CODE_ADD_TASK = 324234;

@Override
protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
    if (resultCode == Activity.RESULT_OK) {
        switch (requestCode) {
            case REQUEST_CODE_ADD_TASK:
                String title = data.getStringExtra("title");
                String desc = data.getStringExtra("desc");
                Tasks newTask = new Tasks(title, desc);
                tasks.add(newTask);
                mAdapter.notifyDataSetChanged();
        }
    }
}