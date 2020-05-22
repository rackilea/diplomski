OutputStream fOut = null;
                        File file = new File(
                                Environment.getExternalStorageDirectory()
                                        + "/FolderName/FolderName2/",
                                fileN);
                        try {
                            fOut = new FileOutputStream(file);
                        } catch (FileNotFoundException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        decodedByte.compress(
                                Bitmap.CompressFormat.JPEG, 85, fOut);
                        try {
                            fOut.flush();
                        } catch (IOException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        try {
                            fOut.close();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        try {
                            MediaStore.Images.Media.insertImage(
                                    getContentResolver(),
                                file.getAbsolutePath(),
                                    file.getName(), file.getName());
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }