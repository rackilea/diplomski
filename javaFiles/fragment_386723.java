String folderId = "some folder id";
File fileMetadata = new File();
fileMetadata.setName("some file title");
fileMetadata.setParents(Collections.singletonList(folderId));
fileMetadata.setMimeType("application/vnd.google-apps.spreadsheet");
File file = driveService.files().create(fileMetadata)
    .setFields("id, parents, name") // properties in the response
    .execute();
System.out.println("File ID: " + file.getId());