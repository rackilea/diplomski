while(zipEntry != null) {
        fileName = zipEntry.getName();
        if(fileName.contains("##TEMP##")) continue;
        if(fileName.contains("MACOSX")) continue;

        // unzipping code

        zipEntry = zis.getNextEntry(); // never happens when filename  contains ##TEMP## or MACOSX 
    }