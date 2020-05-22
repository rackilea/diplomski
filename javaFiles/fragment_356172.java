BufferedInputStream bis = new BufferedInputStream(inputStream);
bis.mark(2);
int byte1 = bis.read();
int byte2 = bis.read();
bis.reset();
// note: you must continue using the BufferedInputStream instead of the inputStream