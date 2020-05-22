// save the images url instead of the Bitmap.
private List<String> mImageUrls = new ArrayList<>();

@Override
protected Void doInBackground(Void... params) {
    try {

        // Connect to the web site
        Document document = Jsoup.connect(url).get();
        // Using Elements to get the class data
        Elements mElementDataSize1 = document.select("h5");
        for (int i = 0; i < mElementDataSize1.size(); i++) {
            Elements img = document.select("[class=product_list grid row] img[src]").eq(i);
            // Locate the src attribute
            String imgSrc = img.attr("src");

            // add the url
            mImageUrls.add(imgSrc);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return v;
}