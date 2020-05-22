String command = "find temp/ -name '*.tif' -or -name '*.jpg' | parallel -j4 kraken -i {} {}.html binarize segment ocr -h";
Process p = Runtime.getRuntime().exec(new String[]{"/bin/bash","-c",command});
InputStream is = p.getInputStream();
// is.skip(Long.MAX_VALUE);  Doesn't work
while (is.read() != -1) { } // consume all process output
p.waitFor();