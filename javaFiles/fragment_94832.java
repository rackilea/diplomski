// Get our EditText object.
EditText vw = (EditText)findViewById(R.id.text);

// Set the EditText's 
text.vw.setText("Italic, highlighted, bold.");

// If this were just a TextView, we could do:
// vw.setText("Italic, highlighted, bold.", TextView.BufferType.SPANNABLE);
// to force it to use Spannable storage so styles can be attached.
// Or we could specify that in the XML.
// Get the EditText's internal text storage

Spannable str = vw.getText();

// Create our span sections, and assign a format to each.

str.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 0, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
str.setSpan(new BackgroundColorSpan(0xFFFFFF00), 8, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 21, str.length() - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);