//To save value of TextView
if (!TextUtils.isEmpty(aTextView.getText())) {
    saveString("aTextView", aTextView.getText().toString());
}

//To Read and show into TextVIew
aTextView.setText(getString("aTextView"));