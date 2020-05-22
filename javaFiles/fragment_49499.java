GsonBuilder gsonB = new GsonBuilder();
Type collectionType = new TypeToken<Response<AudioDto>>() {}.getType();
//Response<AudioDto> response = new Response<AudioDto>();  // you don't need this row

Response<AudioDto> response = gsonB.create().fromJson(responseElement, collectionType);

//assert(response != null);