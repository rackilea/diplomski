JarFile jarFile = new JarFile("my.jar");

    for(Enumeration<JarEntry> em = jarFile.entries(); em.hasMoreElements();) {  
        String s= em.nextElement().toString();

        if(s.startsWith(("path/to/resource/directory/"))){
            ZipEntry entry = jarFile.getEntry(s);

            String fileName = s.substring(s.lastIndexOf("/")+1, s.length());
            if(fileName.endsWith(".yml")){
                InputStream inStream= jarFile.getInputStream(entry);
                OutputStream out = new FileOutputStream(fileName);
                int c;
                while ((c = inStream.read()) != -1){
                    out.write(c);
                }
                inStream.close();
                out.close();

            }
        }
    }  
    jarFile.close();