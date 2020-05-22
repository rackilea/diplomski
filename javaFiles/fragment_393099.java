mDefaultFont1 = mSharedPreferences1.getString("Default_Font1","0");
if (mDefaultFont1.equals("0")) {
    mButton1.setTypeface(mButton1.getTypeface(), Typeface.NORMAL);
} else if (mDefaultFont1.equals("1")) {
    mButton1.setTypeface(mButton1.getTypeface(), Typeface.BOLD);
} else if (mDefaultFont1.equals("2")) {
    mButton1.setTypeface(mButton1.getTypeface(), Typeface.ITALIC);
} else if (mDefaultFont1.equals("3")) {
    mButton1.setTypeface(mButton1.getTypeface(), Typeface.BOLD_ITALIC);
}

mButton1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

    final String[] list = new String[]{"Normal", "Bold", "Italic", "Bold ITalic"};
    AlertDialog.Builder builder = new AlertDialog.Builder(CustomizeFont.this);
    builder.setTitle("Make your selection");
    builder.setItems(list, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
            if (item==0) mButton1.setTypeface(null);
            if (item==1) mButton1.setTypeface(mButton1.getTypeface(),Typeface.BOLD);
            if (item==2) mButton1.setTypeface(mButton1.getTypeface(),Typeface.ITALIC);
            if (item==3) mButton1.setTypeface(mButton1.getTypeface(),Typeface.BOLD_ITALIC);
            editor1 = PreferenceManager.getDefaultSharedPreferences(CustomizeFont.this).edit();
             editor1.putString("Default_Font1", String.valueOf(item));
            editor1.apply();

        }
    });
    builder.show();
 }
 });