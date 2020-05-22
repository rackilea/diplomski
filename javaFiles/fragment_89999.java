List<File> pdfs = new ArrayList<>();
for(File f : files) {
    if(f.getName().toLowerCase().endsWith(".pdf")) {
        pdfs.add(f);
    }
}