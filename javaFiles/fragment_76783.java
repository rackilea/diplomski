final String isLiked = new String();

/* Rest of the code remains the same. */
new Request(Session.getActiveSession(), post_id + "/likes/", null,
        HttpMethod.GET, new Request.Callback() {

        ....
        ....
}