try {
   Scanner numsIn = new Scanner(nums);
catch (FileNotFoundException e) {
  // do something
} finally {
  if (numsIn != null) numsIn .close();
}