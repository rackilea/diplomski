POST https://www.googleapis.com/drive/v3/files?fields=createdTime%2Cid%2Cname%2Cparents

{
  "mimeType": "application/vnd.google-apps.spreadsheet",
  "parents": [
    "some folder id"
  ],
  "name": "API Explorer Sheet in Folder"
}