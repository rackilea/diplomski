private static final char SEPERATOR = '-';

    private void automateDateEntry() {
        dateEditText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 10) {
                    charSequence = charSequence.subSequence(0, 10);
                    dateEditText.removeTextChangedListener(this);
                    dateEditText.setText(charSequence);
                    dateEditText.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String currText = editable.toString();
                if(currText.isEmpty())
                    return;
                int separatorCount = getOcurrence(currText, SEPERATOR);

                if (currText.charAt(currText.length() - 1) == SEPERATOR) {
                    return;
                }
                int lastSeperatorPos = currText.lastIndexOf(SEPERATOR);
                String previousTxt = null;
                if (lastSeperatorPos > -1) {
                    previousTxt = currText.substring(0, lastSeperatorPos + 1);
                    Log.d("curr text", currText);
                    currText = currText.substring(lastSeperatorPos + 1);
                }

                if (!currText.isEmpty()) {
                    switch (separatorCount) {
                        case 0:
                            int date = Integer.parseInt(currText);
                            if (date < 0 || date > 31) {
                                dateEditText.setError("Enter proper date");
                                return;
                            }
                            if (currText.length() == 2 || date >= 4) {
                                currText = String.format(Locale.getDefault(), "%02d", date);
                                currText += SEPERATOR;
                            }
                            break;
                        case 1: int month = Integer.parseInt(currText);
                            if (month < 0 || month > 31) {
                                dateEditText.setError("Enter proper month");
                                return;
                            }
                            if (currText.length() == 2 || month >= 2) {
                                currText = String.format(Locale.getDefault(), "%02d", month);
                                currText += SEPERATOR;
                            }
                            break;
                        case 2: int year = Integer.parseInt(currText);
                            if (year < 0 ) {
                                dateEditText.setError("Enter proper year");
                                return;
                            }
                            break;
                    }
                }
                if(previousTxt != null){
                    currText = previousTxt + currText;
                }
                dateEditText.removeTextChangedListener(this);
                dateEditText.setText(currText);
                int textLength = currText.length();
                dateEditText.setSelection(textLength, textLength);
                dateEditText.addTextChangedListener(this);
            }
        });
    }

    private int getOcurrence(String string, char ch) {
        int count = 0;
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == ch)
                ++count;
        }
        return count;
    }