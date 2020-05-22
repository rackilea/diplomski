public File merge(final List<File> files) throws IoAppException, OtherAppException {
        Path outPath = this.fileStorageService.getPath()
                .resolve(UUID.randomUUID().toString() + Directory.DOCX_EXTENSION);
        File outFile = outPath.toFile();
        try (OutputStream os = new FileOutputStream(outFile);
                InputStream is = new FileInputStream(files.get(0));
                XWPFDocument doc = new XWPFDocument(is);) {


            CTBody ctBody = doc.getDocument().getBody();
            for (int i = 1; i < files.size(); i++) {
                try (InputStream isI = new FileInputStream(files.get(i)); XWPFDocument docI = new XWPFDocument(isI);) {

                    CTBody ctBodyI = docI.getDocument().getBody();
                    appendBody(ctBody, ctBodyI);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new OtherAppException("", e);
                }
            }
            doc.write(os);
            return outFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IoAppException("", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IoAppException("", e);
        }
    }