try (InputStream fis = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(target)){

        byte[] buf = new byte[8192];

        int i;
        while ((i = fis.read(buf)) != -1) {
            fos.write(buf, 0, i);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }