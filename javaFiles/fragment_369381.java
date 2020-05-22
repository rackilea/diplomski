ParseQuery query = new ParseQuery.getQuery("ParentClass");  // change the class name
ParseGeoPoint point = new ParseGeoPoint(40.712784,-74.005941);  // put your location here
query.whereWithinMiles("location",point,30);

ParseQuery venueQuery = new ParseQuery.getQuery("SubClass");  // change the class name
venueQuery.whereMatchesKeyInQuery("venueId","objectId",query);
venueQuery.findInBackground(new FindCallback() {
    @Override
    public void done(List objects, ParseException e) {

    }

    @Override
    public void done(Object o, Throwable throwable) {

    }
});