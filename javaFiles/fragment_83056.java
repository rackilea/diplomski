private void onButtonClick(View view) {
    Button button = (Button) view;
    // Toggle the selected state.
    saveSelectedState(Contact.CONTACT1, !getSelectedState(Contact.CONTACT1));
    boolean selected = getSelectedState(Contact.CONTACT1);
    button.setBackgroundColor(selected ? Color.GREEN : Color.RED); // Change colors to whatever you need.
}