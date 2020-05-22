public String findEmail( ) {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("myTable");
    query.whereEqualTo("email", user.getEmail() );
    try {
        ParseObject object = query.getFirst();
        partnerEmail = object.getString("partnerEmail");
        Log.d("inside", partnerEmail);
    } catch (ParseException e) {
        //error
    }
    Log.d("outside", partnerEmail);
    return partnerEmail;
}