@Override
public View getItemView(Sale sale, View v, ViewGroup parent) {

    ...

    ParseImageView saleImage = (ParseImageView) v.findViewById(R.id.icon);
    ParseFile photoFile = sale.getParseFile("photo");
    if (photoFile != null) {
        saleImage.setParseFile(photoFile);
        saleImage.loadInBackground(new GetDataCallback() {
            @Override
            public void done(byte[] data, ParseException e) {
            }
        });
    } else { // Clear ParseImageView if an object doesn't have a photo
        saleImage.setImageResource(android.R.color.transparent);
    }

    ...
}