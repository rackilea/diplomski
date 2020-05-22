DoneButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String newText = mEditText.getText().toString();
        mTextView.setText(newText);
        SharedPreferences.Editor e = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
        editor .putString ("key","your_value");
        editor .commit();
        getDialog().dismiss();

    }
});