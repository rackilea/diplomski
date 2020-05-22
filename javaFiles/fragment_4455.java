List<ConditionFormatter> formatters = new ArrayList<>(25);
formatters.add(new DefaultConditionFormatter("example text", "<font color=\"FFFFFF\" style=\"background-color: #FFAABB\">", "</font>"));
formatters.add(new DefaultConditionFormatter("back", "<font color=\"FFFFFF\" style=\"background-color: #AAAAAA\">", "</font>"));
formatters.add(new DefaultConditionFormatter("bunnies", "<font color=\"FF0000\" style=\"background-color: #FFFFFF\">", "</font>"));
formatters.add(new DefaultConditionFormatter("red", "<font color=\"FF0000\" style=\"background-color: #000000\">", "</font>"));

String text = "This is a example text background and bunnies are red";
StringJoiner sj = new StringJoiner(")|(", "(", ")");
for (ConditionFormatter formatter : formatters) {
    sj.add(formatter.getCondition());
}

Pattern p = Pattern.compile(sj.toString(), Pattern.CASE_INSENSITIVE);
//...