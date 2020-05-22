ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));
for(int i = 0; i < files.length; i++){
    InputStream in = new FileInputStream(files[i]);
    out.putNextEntry(new ZipEntry(path + files[i].getName()));
    for(int read = in.read(buffer); read > -1; read = in.read(buffer)){
        out.write(buffer, 0, read);
    }
    out.closeEntry();
    in.close();
}

...

out.close();