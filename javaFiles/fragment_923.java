fis = createObject("java", "java.io.FileInputStream");
        lOsPDFInput = createObject("java", "java.io.BufferedInputStream").init(fis.init(arguments.lStrInputPDFfile));
        fos = createObject("java", "java.io.FileOutputStream");
        lOsPDFOutput = createObject("java", "java.io.BufferedOutputStream").init(fos.init(arguments.lStrOutputPDFfile));
        fimgs = createObject("java", "java.io.FileInputStream");
        lSignImage = createObject("java", "java.io.BufferedInputStream").init(fimgs.init(arguments.lStrSignImageFile));
        fkeys = createObject("java", "java.io.FileInputStream");
        lKeyStoreFileStream = createObject("java", "java.io.BufferedInputStream").init(fkeys.init(arguments.lStrKeyStoreFilePath));