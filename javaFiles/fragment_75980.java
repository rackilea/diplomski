public class ComboTableTest {

    private final Display display;
    private final Shell shell;

    public ComboTableTest() {
        display = new Display();
        shell = new Shell(display);
        shell.setLayout(new GridLayout());

        final Table right_group_table = new Table(shell, SWT.BORDER | SWT.MULTI);
        right_group_table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        right_group_table.setLinesVisible(true);
        right_group_table.setHeaderVisible(true);

        final TableColumn right_list_column = new TableColumn(right_group_table, SWT.CENTER);
        right_list_column.setText("TABLE_LIST");
        right_list_column.setWidth(140);

        final TableColumn message_column = new TableColumn(right_group_table, SWT.NONE | SWT.DROP_DOWN);
        message_column.setText("FACEBOOK_MESSAGE");
        message_column.setWidth(230);

        for (int i = 0; i < 10; i++) {
            new TableItem(right_group_table, SWT.DROP_DOWN);
        }

        final TableItem[] items = right_group_table.getItems();

        for (int i = 0; i < items.length; i++) {
            final CCombo templateDropdown = new CCombo(right_group_table, SWT.NONE);
            templateDropdown.setText("CCombo");
            templateDropdown.add("item 1");
            templateDropdown.add("item 2");
            final TableEditor editor = new TableEditor(right_group_table);
            editor.grabHorizontal = true;
            editor.setEditor(templateDropdown, items[i], 1);
        }

    }

    public void run() {
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public static void main(final String... args) {
        new ComboTableTest().run();
    }

}