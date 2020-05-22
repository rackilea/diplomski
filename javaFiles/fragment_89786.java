if (Locale.getDefault().getLanguage().equals("en")) {
     spannableString.setSpan(clickableSpan, 87, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 }
 else if (Locale.getDefault().getLanguage().equals("fr")) {
     spannableString.setSpan(clickableSpan, 50, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 }