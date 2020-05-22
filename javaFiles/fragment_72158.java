PipedOutputStream os = new PipedOutputStream();
   PipedInputStream is = new PipedInputStream(os);

   System.setProperty("org.apache.pdfbox.baseParser.pushBackSize", "2024768");
   InputStream dataStream = secureData.data();

   PDDocument doc = PDDocument.load(dataStream, true);
   AccessPermission ap = new AccessPermission();
   //add what ever perms you need blah blah...
   ap.setCanModify(false);
   ap.setCanExtractContent(false);
   ap.setCanPrint(false);
   ap.setCanPrintDegraded(false);
   ap.setReadOnly();

   StandardProtectionPolicy spp = new StandardProtectionPolicy(UUID.randomUUID().toString(), "", ap);

   doc.protect(spp);

   doc.save(os);
   doc.close();
   dataStream.close();
   os.close();