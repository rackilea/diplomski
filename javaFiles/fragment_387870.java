> >  public static void createCustomToast(Context context,String msg, String status) {
>     >     LayoutInflater inflater = getLayoutInflater();
>     >     View toastRoot = inflater
>     >             .inflate(R.layout.custom_toast_two_lines, null);
>     >     TextView text = (TextView) toastRoot.findViewById(R.id.toastText);
>     >     TextView textTriageStatus = (TextView) toastRoot
>     >             .findViewById(R.id.status);
>     >     textTriageStatus.setText(status);
>     >     text.setTextColor(Color.BLACK);
>     >     text.setText(msg);
>     >     Toast toast = new Toast(context);
>     >     toast.setView(toastRoot);
>     >     toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
>     >     toast.show(); }
>     > 
>     > public static void savePreferences(Context context,String key, int value) {
>     >     SharedPreferences sharedPreferences = context.getSharedPreferences(
>     >             "APP_PREFERENCES", MODE_PRIVATE);
>     >     SharedPreferences.Editor editor = sharedPreferences.edit();
>     >     editor.putInt(key, value);
>     >     editor.commit(); }
>     > 
>     > public void String loadPreferences(Context context,,String key) {
>     >     SharedPreferences sharedPreferences = context.getSharedPreferences(
>     >             "APP_PREFERENCES", MODE_PRIVATE);
>     >     String strSavedMem1 = sharedPreferences.getString(key, "");
>     >     return strSavedMem1; }
>     > 
>     > > Blockquote