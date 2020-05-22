public void onLikeClick(View view) {
    if (clicked) {
        imageView.setImageResource(R.drawable.like_selected);
        clicked = false;
    } else {
        clicked = true;
        imageView.setImageResource(R.drawable.like_unselected);
    }
}