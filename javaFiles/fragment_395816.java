Uri fileUri = Uri.fromFile(new File(filePath));

                        Uri new_uri = Uri.parse("file://"
                                + fileUri.getPath());

                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                new_uri);

                        MimeTypeMap myMime = MimeTypeMap.getSingleton();
                        String fileExt = filePath.substring(filePath
                                .lastIndexOf(".") + 1);
                        String mimeType = myMime
                                .getMimeTypeFromExtension(fileExt);
                        intent.setDataAndType(new_uri, mimeType);

                        startActivity(intent);