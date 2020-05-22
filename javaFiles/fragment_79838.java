String[] fileExt = new String[20];
    for (int i = 0; i < fileExt.length; i++) {
        fileExt[i] = i + ".jpg";
    }

    // view results
    for (int i = 0; i < fileExt.length; i++) {
        System.out.println(fileExt[i]);
    }

// example
    File image = new File(fileExt[0]);