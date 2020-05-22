import java.util.ArrayList;
import java.util.List;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;

public class SimpleSqlParserTableNames2 {

    public static void main(String args[]) throws JSQLParserException {
        System.out.println("eg1");
        Insert insert = (Insert)CCJSqlParserUtil.parse("INSERT INTO Customers (CustomerName, Country) SELECT SupplierName, Country FROM Suppliers WHERE Country='Germany'");
        TablesNamesFinderExt finder = new TablesNamesFinderExt();

        System.out.println("INSERT - " + insert.getTable());
        finder.getTableList(insert.getSelect());
        System.out.println("SELECT - " + finder.getSelectTableList());

        System.out.println("eg2");
        Update update = (Update)CCJSqlParserUtil.parse("UPDATE CUSTOMERS SET SALARY = SALARY * 0.25\n" +
                    "  WHERE AGE IN (SELECT AGE FROM CUSTOMERS_BKP WHERE AGE >= 27 )");
        finder = new TablesNamesFinderExt();
        System.out.println("UPDATE - " + update.getTables());
        finder.getTableList(update);
        System.out.println("SELECT - " + finder.getSelectTableList());

        System.out.println("eg3");
        update = (Update)CCJSqlParserUtil.parse("UPDATE CUSTOMERS SET SALARY = SALARY * 0.25\n" +
                    "WHERE AGE IN (SELECT AGE FROM CUSTOMERS WHERE AGE >= 27 )");
        finder = new TablesNamesFinderExt();
        System.out.println("UPDATE - " + update.getTables());
        finder.getTableList(update);
        System.out.println("SELECT - " + finder.getSelectTableList());
    }

    static class TablesNamesFinderExt extends TablesNamesFinder {
        List<String> mySelectTableList = new ArrayList<>();
        boolean inSelect = true;
        /**
         * To solve JSqlParsers Problem in getting tablenames from subselect using an Insert
         * statement.
         *
         * @param insert
         * @return
         */
        @Override
        public List<String> getTableList(Insert insert) {
            List<String> list = super.getTableList(insert);
            if (insert.getSelect() != null) {
                insert.getSelect().getSelectBody().accept(this);
            }
            return list;
        }

        @Override
        public void visit(SubSelect subSelect) {
            inSelect = true;
            super.visit(subSelect);
        }

        @Override
        public void visit(Table tableName) {
            super.visit(tableName); 
            if (inSelect && !mySelectTableList.contains(tableName.getFullyQualifiedName()))
                mySelectTableList.add(tableName.getFullyQualifiedName());
        }

        public List<String> getSelectTableList() {
            return mySelectTableList;
        }

    }
}