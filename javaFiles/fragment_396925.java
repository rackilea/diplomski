String[] files = {"foo.txt", "bar.txt", "baz.txt"};

for(String file : files) {
    DocumentParser dp = new DocumentParser();
    dp.parseFiles(file);
    dp.getCosineMatrix();
}