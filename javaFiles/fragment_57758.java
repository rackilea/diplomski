for (int prefix = -128; prefix < 128; prefix++) {
  prefixedStartRow[0] = (byte) prefix;
  prefixedStopRow[0] = (byte) prefix;
  scan.setStartRow(prefixedStartRow);
  scan.setStopRow(prefixedStopRow);
  setScan(scan);

  for (InputSplit subSplit : super.getSplits(context)) {
    splits.add((InputSplit) ReflectionUtils.copy(conf,
          (TableSplit) subSplit, new TableSplit());
  }
}