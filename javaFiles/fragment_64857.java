encryptPdf(DataSource source, DataSource source) throws IOException, DocumentException {
                    PdfReader reader = new PdfReader(source);
                    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(source));
                    stamper.setEncryption(USER, OWNER,
                        PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
                    stamper.close();
                    reader.close();
                }