public static final int TAKE_PHOTO_REQUEST = 1889;
public static final int PICK_PHOTO_REQUEST = 1888;

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == Activity.RESULT_OK) {
        if (requestCode == PICK_PHOTO_REQUEST) {
            if (data == null) {
                Log.d(TAG, "Data is null");
                Toast.makeText(getActivity(), getString(R.string.general_error), Toast.LENGTH_LONG).show();
            } else {
                Log.d(TAG, "Data: " + data);
                // the intent has data, so set the media uri
                Log.d(TAG, "adding the data using the getData() method");
                mMediaUri = data.getData();
                Log.d(TAG, "Media Uri: " + mMediaUri);
            }


            // ParseUser.getCurrentUser().put("profilePic", mMediaUri);

            saveImageToParse();

        } else if(requestCode  == TAKE_PHOTO_REQUEST) {
            saveImageToParse();
        }
    } else if (resultCode != Activity.RESULT_CANCELED) {
        Log.d(TAG, "Problem getting the picture from gallery");
        // Toast.makeText(getActivity(), R.string.general_error, Toast.LENGTH_LONG).show();
    }
}