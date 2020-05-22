LayoutInflater mInflater = LayoutInflater.from(this);
View mCustomView = mInflater.inflate(R.layout.your_custom_actionbar_xml, null);

TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text_small);
mTitleTextView.setText("Bla bla bla);

ImageView img = (ImageView) mCustomView.findViewById(R.id.forward);
//.... more view