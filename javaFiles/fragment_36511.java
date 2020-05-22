@Produces(MediaType.TEXT_PLAIN)
public Response getRevisions(...) {

    Stream<Revision> revisionObjects = getRevisions();

    // each Revision option has a getAllData() method that needs called, which returns Supplier<InputStream>
    // each Supplier<InputStream> contains, essentially, a Json record

    // attempt at creating a StreamingOutput that can be sent as a response
    if (revisionObjects != null) {
            Iterator<Revision> revisionIterator = revisionObjects.iterator();
            List<JSONObject> revisionsResponse = new ArrayList<JSONObject>();
            while (revisionIterator.hasNext()) {
                BufferedReader streamReader = new BufferedReader(new InputStreamReader(revisionIterator.next().getAllData().get(), "UTF-8")); 
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                        responseStrBuilder.append(inputStr);
                revisionsResponse.add(new JSONObject(responseStrBuilder.toString());
            }

            return Response.ok(revisionsResponse).build();
    }
    return Response.noContent().build();
}