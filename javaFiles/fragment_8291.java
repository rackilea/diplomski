AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
View titleView = getLayoutInflater().inflate(R.layout.dialog_title, null);

builder.setCustomTitle(titleView);                      //key point 2
builder.setMessage(R.string.main_marvel_info);
builder.setPositiveButton("OK", null);

builder.create().show();