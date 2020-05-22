int lof = con.getContentLength();
int progress = (int)(((float)read * 100) / (float)lof);
plswait.setProgress(progress);
pLog.w("Download", progress+"%");
fos.write(bArray,0,current);
current = bis.read(bArray, 0, BUFFER_SIZE);
read = read + current;