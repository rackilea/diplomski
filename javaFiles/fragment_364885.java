ParcelFileDescriptor fileDescriptor = this.getContentResolver().openFileDescriptor(uri, "r");
            InputStream in = this.getContentResolver().openInputStream(uri);

            CountingInputStreamEntity entity = new CountingInputStreamEntity(in, fileDescriptor.getStatSize());
            entity.setUploadListener(this);
            entity.setContentType("binary/octet-stream");
            entity.setChunked(true); 

            BufferedHttpEntity myEntity = null;
            try {
                myEntity = new BufferedHttpEntity(entity);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            put.setEntity(myEntity);