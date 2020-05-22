@Override
public void onResume(){
    super.onResume();

    Bitmap savedProfilePhoto = readFromInternalStorage("profile.png");

    if (savedProfilePhoto != null){
        mUserProfilePhoto.setImageBitmap(savedProfilePhoto);
    }
}