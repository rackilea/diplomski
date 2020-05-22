Storage.Objects.Get getObject = storage.objects().get("bucket", "object");

OutputStream out = new FileOutputStream("/tmp/object");
// If you're not in AppEngine, download the whole thing in one request, if possible.
getObject.getMediaHttpDownloader().setDirectDownloadEnabled(true);
getObject.executeMediaAndDownloadTo(out);