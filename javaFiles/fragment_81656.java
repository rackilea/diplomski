URL url = new URL(URL); //Connect to the host 
        InputStream in = (InputStream) url.openStream();

        for (String temp : pdfList) {

              url = new URL(URL+temp);// It will connect to www.blablabla.com\document1.pdf 
                  in = (InputStream) url.openStream();
                // Inside Workfolder directory every PDF files in the list will be created and will automatically name it self like it supposed to be 
                Files.copy(in, Paths.get("C:\\Users\\Evan\\Documents\\workFolder\\"+temp), StandardCopyOption.REPLACE_EXISTING);

                    in.close();
                }