CmisObject cmisObject = session.getObjectByPath(path);

if (cmisObject instanceof Document) {
    Document document = (Document) cmisObject;
} else if (cmisObject instanceof Folder) {
    Folder folder = (Folder) cmisDocument;
}