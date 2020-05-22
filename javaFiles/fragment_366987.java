long size = file.length();

int count = 0;
int progress;
while ((len = bufIS.read(byteBuff)) > 0) {
  ...
  count += len;
  if (size > 0L) {
    progress = (int) ((count * 100) / size);
    setProgress(progress);
  }
}