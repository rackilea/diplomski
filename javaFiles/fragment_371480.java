//convert .docx to HTML string
        InputStream in= new FileInputStream(new File(path));
        XWPFDocument document = new XWPFDocument(in);


        XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

        OutputStream out = new ByteArrayOutputStream();


        XHTMLConverter.getInstance().convert(document, out, options);
        String html=out.toString();
        System.out.println(html);