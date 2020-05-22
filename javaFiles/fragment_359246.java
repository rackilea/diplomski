public static String sendFileToBucket(InputStream fileStream, String fileName) throws IOException {

    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Modify access list to allow all users with link to read file
    List<Acl> acls = new ArrayList<>();
    acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
    // the inputstream is closed by default, so we don't need to close it
    // here
    Blob blob = null;
    blob = storage.create(BlobInfo.newBuilder(BUCKET_NAME, fileName).setAcl(acls).build(),
            fileStream);

    return blob.getMediaLink();
}