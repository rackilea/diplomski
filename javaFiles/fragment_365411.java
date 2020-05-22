private void handleLanguageDialog() {
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle(R.string.pick_color)
   .setItems(R.array.lang, new DialogInterface.OnClickListener()                 {
       public void onClick(DialogInterface dialog, int which) {
       // The 'which' argument contains the index position
       // of the selected item
       switch(which)
       {
          case 0:// English
              break;
          case 1:// عربى
              break;
       }
   }
});
return builder.create();
}