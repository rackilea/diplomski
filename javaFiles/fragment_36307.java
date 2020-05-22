public void previous(View view) {
    Animation in  = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
    Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
    imageSwitcher.setInAnimation(out);
    imageSwitcher.setOutAnimation(in);
    Uri imageUri = Uri.parse(imageDir+"/"+imageNames[i]);
    imageSwitcher.setImageURI(null); // THIS FIXED THE OOM ERROR
    imageSwitcher.setImageURI(imageUri);
    decrementImage();
}