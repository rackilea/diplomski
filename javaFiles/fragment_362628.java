private static void printFilesInFolder(Drive service, String folderId) throws IOException {
    Children.List request = service.children().list(folderId);

    do {
        try {
            ChildList children = request.execute();

            for (ChildReference child : children.getItems()) {
                System.out.println("File Id: " + child.getId());
            }
            request.setPageToken(children.getNextPageToken());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            request.setPageToken(null);
        }
    } while (request.getPageToken() != null &&
         request.getPageToken().length() > 0);
}