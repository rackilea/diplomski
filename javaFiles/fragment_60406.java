else if (eventChild == XmlPullParser.END_TAG) {


    if (myParser.getName().equalsIgnoreCase("item")) {

        feedItems.add(new FeedItem(title, date));
        // Output Test
        //Log.d("Test ", title);

    }
    tagNameChild = "";

}