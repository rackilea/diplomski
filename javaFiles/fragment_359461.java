ZipEntry zipEntry;

     while((zipEntry = zis.getNextEntry()) != null) {
        fileName = zipEntry.getName();
        if(fileName.contains("##TEMP##")) continue;
        if(fileName.contains("MACOSX")) continue;

        // unzipping code
    }