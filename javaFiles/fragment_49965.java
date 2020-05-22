/*
 * Table example snippet: sort a table by column
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.2
 */
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class SortTable {
    private TableRow rows[] = new TableRow[] {
            new TableRow(1, "aaa", new Date(1363784269000L)),
            new TableRow(2, "abc", new Date(1367784269000L)),
            new TableRow(3, "efc", new Date(1363584269000L)),
            new TableRow(4, "ccc", new Date(1363734269000L)),
        };
    private Table table;
    private TableColumn intColumn;
    private TableColumn strColumn;
    private TableColumn dateColumn;

    public SortTable() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        table = new Table(shell, SWT.BORDER);
        table.setHeaderVisible(true);
        intColumn = new TableColumn(table, SWT.NONE);
        intColumn.setText("int");
        intColumn.setWidth(50);
        strColumn = new TableColumn(table, SWT.NONE);
        strColumn.setText("string");
        strColumn.setWidth(50);
        dateColumn = new TableColumn(table, SWT.NONE);
        dateColumn.setText("date");
        dateColumn.setWidth(100);

        updateTable();

        Listener sortListener = new Listener() {
            public void handleEvent(Event e) {
                TableColumn column = (TableColumn) e.widget;
                if (column == intColumn) Arrays.sort(rows, BY_VAL);
                if (column == strColumn) Arrays.sort(rows, BY_STR);
                if (column == dateColumn) Arrays.sort(rows, BY_DATE);
                table.setSortColumn(column);
                updateTable();
            }
        };
        intColumn.addListener(SWT.Selection, sortListener);
        strColumn.addListener(SWT.Selection, sortListener);
        dateColumn.addListener(SWT.Selection, sortListener);
        shell.setSize(shell.computeSize(SWT.DEFAULT, SWT.DEFAULT).x, 300);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private void updateTable() {
        table.removeAll();
        for (TableRow row : rows) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(row.asString());
        }
    }

    public final Comparator<TableRow> BY_VAL = new Comparator<TableRow>() {
        @Override
        public int compare(TableRow o1, TableRow o2) {
            if (o1.val < o2.val) return -1;
            if (o1.val > o2.val) return 1;
            return 0;
        }
    }; 

    public final Comparator<TableRow> BY_STR = new Comparator<TableRow>() {
        @Override
        public int compare(TableRow o1, TableRow o2) {
            return o1.str.compareTo(o2.str);
        }
    }; 

    public final Comparator<TableRow> BY_DATE = new Comparator<TableRow>() {
        @Override
        public int compare(TableRow o1, TableRow o2) {
            return o1.date.compareTo(o2.date);
        }
    };

    private class TableRow {
        private int val;
        private String str;
        private Date date;
        private SimpleDateFormat format = new SimpleDateFormat();


        public TableRow(int val, String str, Date date) {
            this.val = val;
            this.str = str;
            this.date = date;
        }

        public String[] asString() {
            return new String[] {Integer.toString(val), str, format.format(date)};
        }
    }

    public static void main(String[] args) {
        new SortTable();
    }
}