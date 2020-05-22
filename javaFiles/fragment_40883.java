public class ExtendedTableView<T> extends TableView<T> {

    public ExtendedTableView(){
        init();
    }
    private void init(){
        this.setEditable(true);
        this.setTableMenuButtonVisible(true);
    }
}