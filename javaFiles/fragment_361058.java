@Multipart
@POST("user/{username}/")
Call<User> updateUserProfile(
        @Path("username") String username,
        @Part MultipartBody.Part photo,
        @Part("json_user") String jsonUser
);

// Some Utils for request
public MultipartBody.Part fileToPart(File file) {
    return MultipartBody.Part.createFormData(
            "photo", // param name
            file.getName(),
            RequestBody.create(MediaType.parse("image/*"), file)
    );
}

// usage 
updateUserProfile("Dude", fileToPart(myFile), new Gson().toJson(myUpdateUser))