SpannableString string = new SpannableString("abc"); 
Drawable d = getResources().getDrawable(R.drawable.ic_group_black_24dp); 
d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight()); 
ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE); 
string .setSpan(span, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE); 
textView.setText(string );