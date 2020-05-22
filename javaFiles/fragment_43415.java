public abstract class MyQueryBuilder {

    protected abstract void addFields(StringBuilder sb);
    protected abstract void addFromPart(StringBuilder sb);
    protected abstract void addWhereClause(StringBuilder sb);

    public final String getQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");

        addFields(sb); //this adds the fields to be selected
        sb.append(" FROM ");

        addFromPart(sb); //this adds the tables in the FROM clause

        addWhereClause(sb); //this adds the where clause
        //...etc
        return sb.toString();
    }
}