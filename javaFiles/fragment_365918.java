AbstractTemplateDump absTd = td.getDumpPart(filterBy.get(columnFilter));
AbstractReportPart absRp = workplanReport.getReportPart(filterBy.get(columnFilter));

absTd.setBudgetStartDate(obj[1] != null ? (Date)obj[1]:null);
absTd.setBudgetEndDate(obj[2] != null ? (Date)obj[2]:null);
absRp.setStartDateby(obj[1] != null ? obj[1].toString():"-");
absRp.setEndDateby(obj[2] != null ? obj[2].toString():"-");
absRp.setDolorHrsby(obj[3] != null ? obj[3].toString():"-");
// ...