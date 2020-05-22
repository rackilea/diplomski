private void addInfoIcon(Drawable infoIconDrawable) {
    int infoIconSizePx = getResources().getDimensionPixelSize(R.dimen.info_icon_size);
    final ImageView ivInfoIcon = new ImageView(getContext());
    ivInfoIcon.setLayoutParams(new LayoutParams(infoIconSizePx, infoIconSizePx));
    ivInfoIcon.setImageDrawable(infoIconDrawable);

    rlInfo.addView(ivInfoIcon);
}