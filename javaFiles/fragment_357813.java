InputStream in = new URL("http://host/path").openStream();
OutputStream out = 
    new URL("ftp://user:pass@host/path").openConnection().getOutputStream();

IOUtils.copy(in, out);

in.close();
out.close();