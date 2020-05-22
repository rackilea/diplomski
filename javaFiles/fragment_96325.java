FileList result = service.files().list()     
.setQ("'root' in parents and mimeType != 'application/vnd.google-apps.folder' and trashed = false")     
.setSpaces("drive")
.setFields("nextPageToken, files(id, name, parents)")
.setPageToken(pageToken)     
.execute();