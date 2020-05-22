public static void signFile(String fileNameIn, String fileNameOut, InputStream privKeyIn, String password, boolean armoredOutput) {

        OutputStream out = null;
        BCPGOutputStream bOut = null;
        OutputStream lOut = null;
        InputStream fIn = null;

        try {
            out = new FileOutputStream(fileNameOut);
            if (armoredOutput) {
                out = new ArmoredOutputStream(out);
            }
            PGPSecretKey pgpSec = readSecretKey(privKeyIn);
            PGPPrivateKey pgpPrivKey = pgpSec.extractPrivateKey(password.toCharArray(), "BC");        
            PGPSignatureGenerator sGen = new PGPSignatureGenerator(pgpSec.getPublicKey().getAlgorithm(), PGPUtil.SHA1, "BC");

            sGen.initSign(PGPSignature.BINARY_DOCUMENT, pgpPrivKey);

            Iterator it = pgpSec.getPublicKey().getUserIDs();
            if (it.hasNext()) {
                PGPSignatureSubpacketGenerator spGen = new PGPSignatureSubpacketGenerator();
                spGen.setSignerUserID(false, (String)it.next());
                sGen.setHashedSubpackets(spGen.generate());
            }

            PGPCompressedDataGenerator cGen = new PGPCompressedDataGenerator(PGPCompressedData.ZLIB);
            bOut = new BCPGOutputStream(cGen.open(out));

            sGen.generateOnePassVersion(false).encode(bOut);

            File file = new File(fileNameIn);
            PGPLiteralDataGenerator lGen = new PGPLiteralDataGenerator();
            lOut = lGen.open(bOut, PGPLiteralData.BINARY, file);
            fIn = new FileInputStream(file);
            int ch = 0;

            while ((ch = fIn.read()) >= 0) {
                lOut.write(ch);
                sGen.update((byte) ch);
            }

            lGen.close();
            sGen.generate().encode(bOut);
            cGen.close();

        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        } finally {
            if (lOut != null) try { lOut.close(); } catch (IOException e) {}
            if (bOut != null) try { bOut.close(); } catch (IOException e) {}
            if (out != null) try { out.close(); } catch (IOException e) {}
            if (fIn != null) try { fIn.close(); } catch (IOException e) {}
        }
    }