@NonNull
@Override
public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
    // ...
    // ...
    if (position == 0) {
       yourImageView.setImageResource(mContext.getResources().getDrawable(R.drawable.your_add_img));
    }
    return convertView;
}