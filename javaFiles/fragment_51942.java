new AsyncTask<Void, Void, GoogleCredential>() {
                @Override
                protected GoogleCredential doInBackground(Void... view) {
                    try {
                        Storage storage = StorageFactory.getService(credential);
                        Storage.Objects.Get getObject = storage.objects().get(BUCKET_NAME, fileName);
                        // Downloading data.
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        getObject.getMediaHttpDownloader().setDirectDownloadEnabled(true);
                        getObject.executeMediaAndDownloadTo(out);

                        OutputStream outputStream = new FileOutputStream (
                                getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
                                        + "/" + fileName);


                        byte[] b = out.toByteArray();

                        final byte[] delimiter = BaseEncoding.base16().lowerCase().decode("0d0a0d0a".toLowerCase());
                        List<byte[]> byteArrays = new LinkedList<>();
                        int begin = 0;
                        outer:
                        for (int i = 0; i < b.length - delimiter.length + 1; i++) {
                            for (int j = 0; j < delimiter.length; j++) {
                                if (b[i + j] != delimiter[j]) {
                                    continue outer;
                                }
                            }
                            byteArrays.add(Arrays.copyOfRange(b, begin, i));
                            begin = i + delimiter.length;
                            break;
                        }
                        byteArrays.add(Arrays.copyOfRange(b, begin, b.length));

                        outputStream.write(byteArrays.get(1));
                        outputStream.close();
                        Log.i(LOG_TAG, "Created: " +
                                getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
                                + "/" + fileName);

                    } catch (GeneralSecurityException e) {
                        Log.e(LOG_TAG, "GCS Api fail: " + e);
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "GCS Api fail: " + e);
                    } catch (NullPointerException e) {
                        Log.e(LOG_TAG, "GCS Api fail: " + e);
                    }
                    return credential;
                }
                @Override
                protected void onPostExecute(final GoogleCredential credential) {
                    Log.i(LOG_TAG, "GCS completed.");
                    // Show file

                }
            }.execute();