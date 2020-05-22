ParseQuery<Comment> query = new ParseQuery<Comment>("Comment");
    query.findInBackground(new FindCallback<Comment>() {
        @Override
        public void done(List<Comment> comments, ParseException e) {

        }
    });