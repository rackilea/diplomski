String tempDir = (String) getServletContext().getAttribute(ServletContext.TEMPDIR);
File tempFile = File.createTempFile("foobar-", ".ttf", new File(tempDir));
InputStream input = getServletContext().getResourceAsStream("/WEB-INF/resources/fonts/foobar.ttf");
Files.copy(input, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
String path = tempFile.getAbsolutePath();
FontFactory.register(path);