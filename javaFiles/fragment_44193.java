String input = "john is a StartDate 10\\11\\2012 EndDate 15\\11\\2012 john is a boy john is StartDate john";
Matcher matcher = Pattern.compile("StartDate (.*?) EndDate (.*?) ").matcher(input);
if (matcher.find()) {
  startDate = matcher.group(1);
  endDate = matcher.group(2);
}