try {
                // get input stream for text
                InputStream is = getAssets().open("text.txt");
                // check size
                int size = is.available();
                // create buffer for IO
                byte[] buffer = new byte[size];
                // get data to buffer
                is.read(buffer);
                // close stream
                is.close();
                            }
            catch (IOException ex) {
                return;
            }