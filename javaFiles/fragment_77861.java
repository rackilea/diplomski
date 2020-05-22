@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.secondMenuSave:
                if (!noteTitle.getText().toString().isEmpty() && !noteBody.getText().toString().isEmpty()) {
                    nDS.open();
                    nDS.updateNote(id, noteTitle.getText().toString(), noteBody.getText().toString());
                    nDS.close();
                    Toast nSave = Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG);
                    nSave.show();
                    Intent nView = new Intent(this, Second2.class);
                    nView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    nView.putExtra("id", id);

                    startActivity(nView);
                    finish();
                } else {
                    Toast notSave = Toast.makeText(this, R.string.do_not_save, Toast.LENGTH_LONG);
                    notSave.show();
                }
                return true;
    }
    return super.onOptionsItemSelected(item);
}