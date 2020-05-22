editButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        stuffManagerInputDialogFragment = MyDialogFragment
             .newInstance(nameTextViewContent, tagTextViewContent);

        stuffManagerInputDialogFragment.show(getFragmentManager(), "TEST");
    }
});