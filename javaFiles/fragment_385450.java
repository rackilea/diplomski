public class PrestoParserTest {
    public static void main(String[] args) {
        SqlParser parser = new SqlParser();
        String sql = "select * from xyz where x=y group by x order by y limit 10";
        Query query = (Query)parser.createStatement(sql);
        QuerySpecification body = (QuerySpecification)query.getQueryBody();
        Select select = body.getSelect();
        System.out.println("Columns = " + select.getSelectItems());
        System.out.println("From = " + body.getFrom().get());
        Optional<Expression> where = body.getWhere();
        System.out.println("Where = " + where.get());
        System.out.println("Group by = " + body.getGroupBy());
        System.out.println("Order by = " + body.getOrderBy());
        System.out.println("Limit = " + body.getLimit().get());

    }
}