BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
FileLock lock = fis.getChannel().lock();

BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
String str;
while ((str = br.readLine()) != null) {
    //... code for manipulation of str
    bw.write(str);
    bw.newLine();
}
lock.release();