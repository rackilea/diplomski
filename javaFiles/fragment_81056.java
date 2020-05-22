for (int i = 0; i < mElementDataSize1.size(); i++) {

    ...
    String imgSrc = img.attr("src");

    // You accumulate the the time needed to decode the image here.
    bitmap = BitmapFactory.decodeStream(input);
    ...
}