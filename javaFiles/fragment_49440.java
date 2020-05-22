public class YourActivityOrWhatYouNeed{
    String startTime="";
    String endTime="";
    ...
    ...
    ...


ParseQuery<ParseObject> startQuery = ParseQuery.getQuery("clockIn");
startQuery.getInBackground(clockInId, new GetCallback<ParseObject>() {
    public void done(ParseObject clockIn, ParseException e) {
        if (e == null) {
            startTime = clockIn.getString("Time");
        } else {
            // something went wrong
        }
    }
});

//Retrieve clockOutId (ObjectID for clockOutTime)
ParseQuery<ParseObject> endQuery = ParseQuery.getQuery("clockOut");
endQuery.getInBackground(clockOutId, new GetCallback<ParseObject>() {
    public void done(ParseObject clockOut, ParseException e) {
        if (e == null) {
            endTime = clockOut.getString("Time");
        } else {
            // something went wrong
        }
    }
});