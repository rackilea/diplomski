videoColumnIndex = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);

long fileSizeInBytes = videoCursor.getLong(videoColumnIndex)
// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
long fileSizeInKB = fileSizeInBytes / 1024;
// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
long fileSizeInMB = fileSizeInKB / 1024;