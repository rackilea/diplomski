CloudBlockBlob blob = container.getBlockBlobReference(UserInfo.username + ".jpg");
            BlobOutputStream blobOutputStream = blob.openOutputStream();
            ContentResolver cr = context.getContentResolver();
            InputStream s = cr.openInputStream(uri);
            byte[] arr = convertInputStreamToByteArray(s);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
            int next = inputStream.read();
            while (next != -1) {
                blobOutputStream.write(next);
                next = inputStream.read();
            }
            blobOutputStream.close();