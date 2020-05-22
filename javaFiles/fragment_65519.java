public String createEvent( String name, 
                           String startTime, 
                           String endTime,
                           String imageName,
                           String imagePath ) {   // or maybe even "File image", where you would derive the path
    requireAuthorization();
    MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
    data.set("name", name);
    data.set("start_time", startTime);
    data.set("end_time", endTime);

    data.set( "@" + imageName, "@" + imagePath );  // <<< adding this line

    return graphApi.publish("me", "events", data);
}