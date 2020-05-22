import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        Table table = createTable(
            createRow(
                createCol("Mushrooms", null),
                createCol(1, null)),
            createRow(
                createCol("Onions", null),
                createCol(1, null)),
            createRow(
                createCol("Olives", null),
                createCol(1, null)),
            createRow(
                createCol("Zucchini", null),
                createCol(1, null)),
            createRow(
                createCol("Pepperoni", null),
                createCol(1, null)));

        System.out.println(new Gson().toJson(table));
    }

    public static Table createTable(Row... rows) {
        Table table = new Table();
        table.setRows(Arrays.asList(rows));
        return table;
    }

    public static Row createRow(Col... cols) {
        Row row = new Row();
        row.setC(Arrays.asList(cols));
        return row;
    }

    public static Col createCol(Object v, Object f) {
        Col col = new Col();
        col.setV(v);
        col.setF(f);
        return col;
    }

    static class Table {
        private List<Row> rows;

        public Table() { }

        public List<Row> getRows() {
            return rows;
        }

        public void setRows(List<Row> rows) {
            this.rows = rows;
        }
    }

    static class Row {
        private List<Col> c;

        public Row() { }

        public List<Col> getC() {
            return c;
        }

        public void setC(List<Col> c) {
            this.c = c;
        }
    }

    static class Col {
        private Object v;
        private Object f;

        public Col() { }

        public Object getV() {
            return v;
        }

        public void setV(Object v) {
            this.v = v;
        }

        public Object getF() {
            return f;
        }

        public void setF(Object f) {
            this.f = f;
        }
    }
}