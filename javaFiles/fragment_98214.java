public void beforeTextChanged(CharSequence s, int start,
        int count, int after) {
    try {
        if (count == 1 && after == 0 &&// tried to delete a char
                s.length() >= ".sa.".length() && // string could contain an emoticon
                s.subSequence(start - ".sa.".length() + 1, start + 1).toString().equals(".sa.")// the last string is .sa.
                ) {
            et.setText(s.subSequence(0, s.length() - ".sa.".length()));
        }
    } catch (Exception e) {
    }
}