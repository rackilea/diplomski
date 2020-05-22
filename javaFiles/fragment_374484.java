private void checkFile(File dir) {
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (dir.exists()) {
            copyFiles("/tessdata/eng.traineddata");
            copyFiles("/tessdata/hin.traineddata");
            copyFiles("/tessdata/fra.traineddata");
        }
    }

    private void copyFiles(String path) {
        try {
            String filepath = datapath + path;
            if (!new File(filepath).exists()) {
                AssetManager assetManager = getAssets();

                InputStream instream = assetManager.open(path);
                OutputStream outstream = new FileOutputStream(filepath);

                byte[] buffer = new byte[1024];
                int read;
                while ((read = instream.read(buffer)) != -1) {
                    outstream.write(buffer, 0, read);
                }


                outstream.flush();
                outstream.close();
                instream.close();

                File file = new File(filepath);
                if (!file.exists()) {
                    throw new FileNotFoundException();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }