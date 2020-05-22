// 1st InputStream from your compressed file
FileInputStream in = new FileInputStream(tarbz2File);
// wrap in a 2nd InputStream that deals with compression
BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
// wrap in a 3rd InputStream that deals with tar
TarArchiveInputStream tarIn = new TarArchiveInputStream(bzIn);
ArchiveEntry entry = null;

while (null != (entry = tarIn.getNextEntry())){
    if (entry.getSize() < 1){
        continue;
    }
    // use your parser here, the tar inputStream deals with the size of the current entry
    parser.parse(tarIn);
}
tarIn.close();