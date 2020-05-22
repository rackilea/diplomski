public static byte[] encrypt(byte[] data, InputStream pubKeyIn, boolean isPublicKeyArmored) {

        FileOutputStream fos = null;
        BufferedReader isr = null;

        try {
            if (isPublicKeyArmored) pubKeyIn = new ArmoredInputStream(pubKeyIn);
            PGPPublicKey key = readPublicKeyFromCol(pubKeyIn);
            log.info("Creating a temp file...");
            // Create a file and write the string to it.
            File tempfile = File.createTempFile("pgp", null);
            fos = new FileOutputStream(tempfile);
            fos.write(data);
            fos.close();
            log.info("Temp file created at: " + tempfile.getAbsolutePath());
            log.info("Reading the temp file to make sure that the bits were written...\n");
            isr = new BufferedReader(new FileReader(tempfile));
            String line = "";
            while ((line = isr.readLine()) != null ) {
                log.info(line + "\n");
            }
            int count = 0;
            for (java.util.Iterator iterator = key.getUserIDs(); iterator.hasNext();) {
                count++;
                log.info(iterator.next());
            }
            log.info("Key Count = " + count);
            // Encrypt the data.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            _encrypt(tempfile.getAbsolutePath(), baos, key);
            log.info("Encrypted text length = " + baos.size());         
            tempfile.delete();
            return baos.toByteArray();
        } catch (PGPException e) {
            log.error(e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        } finally {
            if (fos != null) try { fos.close(); } catch (IOException e) {}
            if (isr != null) try { isr.close(); } catch (IOException e) {}
        }
    }