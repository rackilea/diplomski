SpannableString styledString
  = new SpannableString("Large\n\n"     // index 0 - 5
       + "Bold\n\n"          // index 7 - 11
       + "Underlined\n\n"    // index 13 - 23
       + "Italic\n\n"        // index 25 - 31
       + "Strikethrough\n\n" // index 33 - 46
       + "Colored\n\n"       // index 48 - 55
       + "Highlighted\n\n"   // index 57 - 68
       + "K Superscript\n\n" // "Superscript" index 72 - 83 
       + "K Subscript\n\n"   // "Subscript" index 87 - 96
       + "Url\n\n"           //  index 98 - 101
       + "Clickable\n\n");   // index 103 - 112

 // make the text twice as large
 styledString.setSpan(new RelativeSizeSpan(2f), 0, 5, 0);

 // make text bold
 styledString.setSpan(new StyleSpan(Typeface.BOLD), 7, 11, 0);

 // underline text
 styledString.setSpan(new UnderlineSpan(), 13, 23, 0);

 // make text italic
 styledString.setSpan(new StyleSpan(Typeface.ITALIC), 25, 31, 0);

 styledString.setSpan(new StrikethroughSpan(), 33, 46, 0);

 // change text color
 styledString.setSpan(new ForegroundColorSpan(Color.GREEN), 48, 55, 0);

 // highlight text
 styledString.setSpan(new BackgroundColorSpan(Color.CYAN), 57, 68, 0);

 // superscript
 styledString.setSpan(new SuperscriptSpan(), 72, 83, 0);
 // make the superscript text smaller
 styledString.setSpan(new RelativeSizeSpan(0.5f), 72, 83, 0);

 // subscript
 styledString.setSpan(new SubscriptSpan(), 87, 96, 0);
 // make the subscript text smaller
 styledString.setSpan(new RelativeSizeSpan(0.5f), 87, 96, 0);

 // url
 styledString.setSpan(new URLSpan("http://www.google.com"), 98, 101, 0);

 // clickable text
 ClickableSpan clickableSpan = new ClickableSpan() {

 @Override
 public void onClick(View widget) {
    // We display a Toast. You could do anything you want here.
    Toast.makeText(SpanExample.this, 
    "Clicked",Toast.LENGTH_SHORT).show();

    }
 };

styledString.setSpan(clickableSpan, 103, 112, 0);

// this step is mandated for the url and clickable styles.
textView.setMovementMethod(LinkMovementMethod.getInstance());

// make it neat
textView.setGravity(Gravity.CENTER);

tvTitle.setText(styledString);