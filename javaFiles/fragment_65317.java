public static class MyValueMapper implements HBaseValueMapper {
  @Override
  public List<Values> toValues(ITuple tuple, Result result) throws Exception {
    List<Values> values = new ArrayList<Values>();
    Cell[] cells = result.rawCells();

    values.add(new Values(Bytes.toString(CellUtil.cloneValue(cells[0])), Bytes.toInt(CellUtil.cloneValue(cells[1]))));
    return values;
  }
  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    declarer.declare(new Fields("type","age"));
  }
}