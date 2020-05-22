class ResultVO {

String x;
String y;
  public ResultVO(String x,List<Z> y) {
     this.x = x;
     this.y = createCSV(y);
  }
}

then in HQL
select new ResultVO(a.x,a.y) from a