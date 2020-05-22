if (Imagepaths.size() > 1) {
        File file = new File(Imagepaths.get(1));

        MEDIA_TYPE = Imagepaths.get(0).endsWith("png") ? 
                MediaType.parse("image/png") : MediaType.parse("image/jpeg");


        RequestBody imageBody = RequestBody.create(MEDIA_TYPE, file);
        mRequestBody.addFormDataPart("IMAGE2", "IMAGE2", imageBody);
    }