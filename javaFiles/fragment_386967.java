public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    ImageView imageView;
    CustomTextView textView;
    LinearLayout main_grl;

    if (v == null) {
        v = layoutInflater.inflate(R.layout.professions_gridview_item,parent,false);
    }

    main_grl = (LinearLayout)v.findViewById(R.id.main_grl);
    main_grl.setBackground(ContextCompat.getDrawable(mContext,R.drawable.ps_background_selector));
    imageView = (ImageView) v.findViewById(R.id.imageView);
    textView = (CustomTextView) v.findViewById(R.id.textView);
    imageView.setImageResource(ApplicationConstants.finalListIV[position]);
    textView.setText(ApplicationConstants.finalListTV[position]);
    v.setTag(ApplicationConstants.finalListTV[position]);

    return v;
}