@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (view == null) {
        view = layoutInflater.inflate(R.layout.single_item, null);
    }

    ImageView imageView = view.findViewById(R.id.imageView);
    TextView textView = view.findViewById(R.id.textView);
    imageView.setImageResource(dataModels.get(i).resourceId);
    textView.setText(dataModels.get(i).imageName);
    return view;
}