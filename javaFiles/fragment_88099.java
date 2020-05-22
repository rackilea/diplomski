String sqlStr = "SELECT mytable alias FROM mytable";
Select select = (Select)CCJSqlParserUtil.parse(sqlStr);
System.out.println(select.getSelectBody());

PlainSelect pl = (PlainSelect)select.getSelectBody();
for (SelectItem item : pl.getSelectItems()) {
    System.out.println(item.toString());
}