@Override
public void onBackPressed() {
    if (!tempCatatan.equals(edtContent.getText().toString()))
        konfirmasiSave();
    else super.onBackPressed(); // Do that in the else part.
}