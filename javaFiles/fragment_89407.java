/**
 * @author Paul Nelson Baker
 * @see <a href="https://github.com/paul-nelson-baker/">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/paul-n-baker/">LinkedIn</a>
 * @since 2018-09
 */
public class SqlStatementListener extends MySqlParserBaseListener {

    private final Consumer<String> sqlStatementConsumer;

    public SqlStatementListener(Consumer<String> sqlStatementConsumer) {
        this.sqlStatementConsumer = sqlStatementConsumer;
    }

    @Override
    public void enterSqlStatement(MySqlParser.SqlStatementContext ctx) {
        if (ctx.getChildCount() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            recreateStatementString(ctx.getChild(0), stringBuilder);
            stringBuilder.setCharAt(stringBuilder.length() - 1, ';');
            String recreatedSqlStatement = stringBuilder.toString();
            sqlStatementConsumer.accept(recreatedSqlStatement);
        }
        super.enterSqlStatement(ctx);
    }

    private void recreateStatementString(ParseTree currentNode, StringBuilder stringBuilder) {
        if (currentNode instanceof TerminalNode) {
            stringBuilder.append(currentNode.getText());
            stringBuilder.append(' ');
        }
        for (int i = 0; i < currentNode.getChildCount(); i++) {
            recreateStatementString(currentNode.getChild(i), stringBuilder);
        }
    }
}