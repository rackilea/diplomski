private void handleSignInResult(GoogleSignInResult result) {    
    if (result.isSuccess()) {
        // Signed in successfully, show authenticated UI.
        GoogleSignInAccount acct = result.getSignInAccount();
        ...
        Uri uri = acct.getPhotoUrl();
        Picasso.with(mContext)
                .load(uri)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(mProfileImageView);
        // then call mProfileImageView.setOnClickListener();...

        updateUI(true);
    } else {
        // Signed out, show unauthenticated UI.
        updateUI(false);
    }
}