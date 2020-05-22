String githubZip = "https://github.com/testuser/testproject/archive/master.zip"

    ZipInputStream zipInputStream = null
    String[] javaFiles;
    try {
        zipInputStream = new ZipInputStream(new URL(githubZip).openStream());
        ZipEntry zipEntry;

        while( (zipEntry = zipInputStream.getNextEntry())!=null ) {
            if(!zipEntry.isDirectory() && zipEntry.getName().endsWith("java")){
                StringWriter stringWriter = new StringWriter()
                IOUtils.copy(zipInputStream, stringWriter)
                String fileContent = stringWriter.toString();

                javaFiles[zipEntry.getName()] = fileContent
                stringWriter.close()
            }
        }
    } catch (Exception e){
        e.printStackTrace()
    } finally {
        zipInputStream.close()
    }