SortReplays sort = new SortReplays(Arrays.asList(files));
List<File> fileList = sort.sort("length");
Service.out("scala sort by length, time spend: " + (System.currentTimeMillis() - t1));
try {
  controller.refreshLengths(fileList.toArray(new File[0]));
  controller.refreshReplays(fileList.toArray(new File[0]));
} catch (Exception e1) {
  e1.printStackTrace();
}