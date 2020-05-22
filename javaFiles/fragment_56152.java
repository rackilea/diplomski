@Override
public void afterTextChanged(Editable s) {
    SpannableStringBuilder ssb = new SpannableStringBuilder(s.toString());

    for (int i = 0; i<keyWords.size(); i++){
        String keyword = keyWords.get(i);
        Pattern pattern = Pattern.compile("\\b"+keyword+"\\b");
        Matcher matcher = pattern.matcher(ssb);
        while(matcher.find()){
            // Have to create a new instance of FgColor for this to work!!
            // KeywordColors is a Hashmap mapping keywords to the color they should be highlighted with
            ForegroundColorSpan fg = new ForegroundColorSpan(keywordColors.get(keyword).getForegroundColor());
            ssb.setSpan(fg, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    codeEditText.removeTextChangedListener(this);
    codeEditText.setText(ssb);
    codeEditText.addTextChangedListener(this);

    codeEditText.setSelection(codeEditText.getText().length());

}