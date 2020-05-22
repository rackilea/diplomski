final ParseFile imageFile = new ParseFile("image.jpg", bytes);
ParseUser.getCurrentUser().put(ParseUtils.PARSE_PROFILE_IMAGE, imageFile);
ParseUser.getCurrentUser().saveInBackground(new SaveCallback() {
    @Override
    public void done(ParseException e) {
        if (e == null) {
            Log.i("LoginActivity", "Profile saved succesfully");

        } else {
            e.printStackTrace();
        }
    }
});