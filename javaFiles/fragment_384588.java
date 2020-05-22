public class TableTest extends Application {
final Table table = new Table();
final IndexedContainer ic = new IndexedContainer();

@Override
public void init() {
    setMainWindow(new Window("Window"));
    createTable();
    getMainWindow().addComponent(table);
    getMainWindow().addComponent(
            new Button("Click me", new Button.ClickListener() {
                public void buttonClick(ClickEvent event) {
                    updateData();
                }
            }));
}

public void createTable() {
    table.setImmediate(true);
    table.setEnabled(true);
    ic.addContainerProperty("Name", String.class, null);
    ic.addContainerProperty("Edit", Button.class, null);
    ic.addContainerProperty("Delete", Button.class, null);
    table.setContainerDataSource(ic);
}

public void updateData() {
    ic.removeAllItems();
    ic.addItem("myname");
    ic.getContainerProperty("myname", "Name").setValue("Mr.X");
    System.out.println("see the output but no update on table");
}
}