YearMonth from = YearMonth.of(2010, 10);
YearMonth to = YearMonth.of(2011, 2);
List<YearMonth> list = new ArrayList<> ();

for (YearMonth ym = from; !ym.isAfter(to); ym = ym.plusMonths(1)) {
  list.add(ym);
}