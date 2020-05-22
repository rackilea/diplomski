try {
            InputStream in = new ByteArrayInputStream(base64.getBytes());
            FileOutputStream out = new FileOutputStream(resultPath);
            while (in.available() > 0) {
                byte[] buffer = new byte[1024];
                in.read(buffer);

                byte[] decoded = Base64.decode(buffer, Base64.DEFAULT);
                out.write(decoded, 0, decoded.length);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {}