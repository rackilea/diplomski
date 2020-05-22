@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    //working with an object called "hl"
    if (view == null){
        view = myInflater.inflate(R.layout.headline_list, null);
    }

    Bitmap background = hl.getBgImage();
    Drawable dr = new BitmapDrawable(background);
    view.setBackgroundDrawable(dr);
    return view;
}