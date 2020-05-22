View rootView = inflater.inflate(R.layout.history_moadim_a, container, false);

horef = (TextView) rootView.findViewById(R.id.textView3);
Spannable wordtoSpan = new SpannableString("hgh");
horef.setText(wordtoSpan);

return rootView;