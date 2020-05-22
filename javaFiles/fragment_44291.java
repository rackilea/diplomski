ArrayList<String> placeIDsList = new ArrayList<>();
placeIDsList.add("ChIJTaKjynxesBQREvi1CU5QUFg");
placeIDsList.add("EjhDdW1odXJpeWV0IE1haGFsbGVzaSwgVXp1biBTay4sIEV6aW5lL8OHYW5ha2thbGUsIFR1cmtleSIuKiwKFAoSCakQkmN8XrAUEVkLpNK_F4IJEhQKEgmFzKyYe16wFBGSjU7F2ooIIg");
placeIDsList.add("hIJy9YVxdxpsBQRq0-xUVJdZQ8");

// Specify the fields to return (in this example all fields are returned).
List<Place.Field> placeFields = Arrays.asList(Place.Field.ID);

for (String plc : placeIDsList ) {
    // Construct a request object, passing the place ID and fields array.
    FetchPlaceRequest request = FetchPlaceRequest.builder(plc, placeFields).build();

    Log.e(TAG,"request for place with ID = " + plc);

    placesClient.fetchPlace(request).addOnSuccessListener((response) -> {
        Place place = response.getPlace();


        if (!plc.equals(place.getId())) {
            Log.e(TAG,"placeID renewed");
            Log.e(TAG,"placeID old = " + plc);
            Log.e(TAG,"placeID new = " + place.getId());

        } else {
            Log.e(TAG, "Place found: " + place.getId());
        }


    }).addOnFailureListener((exception) -> {
        if (exception instanceof ApiException) {
            ApiException apiException = (ApiException) exception;
            int statusCode = apiException.getStatusCode();
            // Handle error with given status code.
            Log.e(TAG, "Place with ID "+plc+" not found");
            Log.e(TAG, "Exception message is :" + exception.getMessage());
            Log.e(TAG, "Status code = " + statusCode);
        }
    });
}