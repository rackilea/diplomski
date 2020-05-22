public class DragAndDropTables extends HorizontalLayout {

    public DragAndDropTables() {
        // leave some space between the tables
        setSpacing(true);

        // tables
        Table toDoTable = createTable("To do");
        Table inProgressTable = createTable("In progress");
        Table doneTable = createTable("Done");

        // drop handlers which allow only drops from expected sources
        configureDragAndDrop(toDoTable, inProgressTable, doneTable);
        configureDragAndDrop(inProgressTable, toDoTable, doneTable);
        configureDragAndDrop(doneTable, toDoTable, inProgressTable);

        // some table to make sure AcceptCriterion allows drops only from expected sources
        Table tableNotAcceptableForDrops = createTable("Drops from here will not be accepted");
        configureDragAndDrop(tableNotAcceptableForDrops);
        tableNotAcceptableForDrops.addItem(new Task(100, "Not droppable task"));

        // add some dummy data
        for (int i = 0; i < 10; i++) {
            toDoTable.addItem(new Task(i, "Task " + i));
        }

        // add the tables to the UI
        addComponent(toDoTable);
        addComponent(inProgressTable);
        addComponent(doneTable);
        addComponent(tableNotAcceptableForDrops);
    }

    private Table createTable(String caption) {
        // basic table setup
        Table table = new Table(caption);
        BeanItemContainer<Task> itemContainer = new BeanItemContainer<>(Task.class);
        table.setContainerDataSource(itemContainer);
        table.setMultiSelect(true);
        table.setSelectable(true);
        table.setPageLength(10);
        return table;
    }

    private void configureDragAndDrop(Table table, Table... acceptedSources) {
        // drag & drop configuration
        table.setDragMode(Table.TableDragMode.MULTIROW);
        table.setDropHandler(new DropHandler() {
            @Override
            public void drop(DragAndDropEvent event) {
                // where the items are dragged from
                Table source = (Table) event.getTransferable().getSourceComponent();

                // where the items are dragged to
                Table target = (Table) event.getTargetDetails().getTarget();

                // unique collection of dragged tasks
                HashSet<Task> draggedTasks = new HashSet<>();

                // https://vaadin.com/api/com/vaadin/ui/Table.TableDragMode.html
                // even in MULTIROW drag mode, the event contains only the row on which the drag started
                draggedTasks.add((Task) event.getTransferable().getData("itemId"));

                // we'll get the rest, if any, from the source table selection value
                draggedTasks.addAll((Collection<Task>) source.getValue());

                // remove items from source table
                draggedTasks.forEach(((Table) source)::removeItem);

                // add items to destination table
                target.addItems(draggedTasks);
            }

            @Override
            public AcceptCriterion getAcceptCriterion() {
                // accept drops only from specified tables, and prevent drops from the source table
                return new SourceIs(acceptedSources);
            }
        });
    }


    // basic bean for easy binding
    public static class Task {
        private String name;
        private int id;

        public Task(int id, String name) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}