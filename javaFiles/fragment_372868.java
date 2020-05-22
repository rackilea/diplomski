public void execute(Tuple input) {
  if (tuple.getIntegerByField("theDecider") == 1) {
    collector.emit("onlyOnes", tuple.getValues());
  } else {
    collector.emit("others", tuple.getValues());
  }
}