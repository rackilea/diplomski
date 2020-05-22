boolean mIsInTextWatcher = false;

@Override
public void afterTextChanged(Editable s) {
    if (mIsInTextWatcher)
        return;
    mIsInTextWatcher = true;

    // do whatever you do, possibly modifying the text

    mIsInTextWatcher = false;
}