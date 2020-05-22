public static String upload(File file) throws IOException {
        Cloudinary cloudinary = new Cloudinary(CONFIG);
        Map<Object, Object> parameters = new HashMap<>();
        parameters.put("public_id", "Bookstore/Authors/Images/vejder");

        Map result = cloudinary.uploader().upload(file, parameters);

        return (String) result.get("url");
    }