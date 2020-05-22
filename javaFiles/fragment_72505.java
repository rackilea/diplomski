URL url = new URL(fileUrl);
                URLConnection connection = url.openConnection();
                connection.connect();
                int fileLength = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());                  
                OutputStream output = new FileOutputStream(output.getPath());
                byte data[] = new byte[1024];
                int count;
                while ((count = input.read(data)) != -1) {
                    output.write(data, 0, count);
                }
                output.flush();
                input.close();
                result = Activity.RESULT_OK;