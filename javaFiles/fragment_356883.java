SpannableString span1 = new SpannableString("pravind ");
    SpannableString span2 = new SpannableString("kumar");

    span1 .setSpan(new ForegroundColorSpan(Color.BLUE), 5, 13, 
                                                   Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
       span2.setSpan(new ForegroundColorSpan(Color.RED), 5, 13, 
                                                   Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        mTextView.setText(TextUtils.concat(span1," " ,span2));