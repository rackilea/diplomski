protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case PICK_EXISTING_PHOTO_RESULT_CODE:

            if ( RESULT_OK == resultCode) {
                final Uri photoUri = data.getData();
                createAlert(photoUri);
            }

            break;
        default:
            facebook.authorizeCallback(requestCode, resultCode, data);
            break;
    }
}

public void createAlert(final Uri photoUri) {
    final AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Enter Caption for Photo");
    alert.setMessage("Caption :");

    final EditText input = new EditText(this);
    alert.setView(input);

    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(final DialogInterface dialog, final int whichButton) {
            final String caption = input.getText().toString();
            postToFacebook(photoUri, caption);
        }
    });

    alert.setNegativeButton("Cancel", null);
    final AlertDialog helpDialog = alert.create();
    helpDialog.show();
}

private void postToFacebook(final Uri photoUri, final String caption) {
    final String imagePath = getPath(photoUri);
    final byte[] data1 = null;

    Bitmap bi = BitmapFactory.decodeFile(imagePath);
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bi.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    data1 = baos.toByteArray();
    bi.recycle();
    bi = null;

    final Bundle params = new Bundle();
    params.putString(Facebook.TOKEN, facebook.getAccessToken());
    params.putString("caption", caption);
    params.putByteArray("photo", data1);

    try {
        facebook.request("me/photos", params, "POST");
    } catch (final FileNotFoundException e) {
        e.printStackTrace();
    } catch (final MalformedURLException e) {
        e.printStackTrace();
    } catch (final IOException e) {
        e.printStackTrace();
    }
}