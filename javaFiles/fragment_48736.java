DbxEntry entry = client.getMetadata("/testFolder");
if (entry instanceof DbxEntry.Folder) {
    DbxEntry.Folder folder = (DbxEntry.Folder)entry;

    System.out.println(folder.toStringMultiline());
}