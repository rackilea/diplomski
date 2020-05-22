public static StorageObject uploadSimpleImageAndMakeItPublic(
            Storage storage, String bucketName, String objectName,
            InputStream imageData) throws IOException {
        InputStreamContent mediaContent = new InputStreamContent("image/png", imageData);
        Storage.Objects.Insert insertObject = storage.objects()
                            .insert(bucketName, null, mediaContent).setName(objectName);
        insertObject.getMediaHttpUploader().setDisableGZipContent(true);
        StorageObject uploadedImage = insertObject.execute();

        // new acl to make it public
        ObjectAccessControl publicACLItem = new ObjectAccessControl();
        publicACLItem.setEntity("allUsers");
        publicACLItem.setRole("READER");
        Insert insert = storage.objectAccessControls().insert(bucketName, objectName, publicACLItem);
        insert.execute();
        return uploadedImage;               
    }