class MySplit extends org.apache.hadoop.mapred.FileSplit {

public MySplit(InputSplit actualSplit, String hiveInputPath) {
  super (new Path(hiveInputPath), 0,0, (String[]) null);
  this.actualSplit = actualSplit;
}

//do not override getPath that way hiveInputPath is returned

InputSplit getActualSplit() {
  return actualSplit;
}

....
}