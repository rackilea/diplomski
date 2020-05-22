String requestUrl = "https://api.gdc.cancer.gov/data/556e5e3f-0ab9-4b6c-aa62-c42f6a6cf20c";
    URL url = new URL(requestUrl);
    InputStream in = url.openStream();
    Files.copy(in, Paths.get("your_filename.pdf"), StandardCopyOption.REPLACE_EXISTING);
    in.close();
    System.out.println("finished!");