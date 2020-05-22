LinearLayout root = (LinearLayout) getActivity().findviewById(R.id.rootLayout);
    while(mNotesCursor.moveToNext()){
        TextView tv = new TextView(getActivity());
        tv.setText(mNotesCursor.getString(mNotesCursor.getColumnIndex("title")));
        root.addView(tv);
    }