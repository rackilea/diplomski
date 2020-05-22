/**
 * use this method to set clickable highlighted a text in TextView
 *
 * @param tv              TextView or Edittext or Button or child of TextView class
 * @param textToHighlight Text to highlight
 */
public void setClickableHighLightedText(TextView tv, String textToHighlight, View.OnClickListener onClickListener) {
    String tvt = tv.getText().toString();
    int ofe = tvt.indexOf(textToHighlight, 0);
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            if (onClickListener != null) onClickListener.onClick(textView);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(0xff0000ff);
            ds.setUnderlineText(true);
        }
    };
    SpannableString wordToSpan = new SpannableString(tv.getText());
    for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
        ofe = tvt.indexOf(textToHighlight, ofs);
        if (ofe == -1)
            break;
        else {
            wordToSpan.setSpan(clickableSpan, ofe, ofe + textToHighlight.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(wordToSpan, TextView.BufferType.SPANNABLE);
            tv.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}