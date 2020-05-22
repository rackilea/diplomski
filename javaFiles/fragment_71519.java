public class TableUtils {

    public static <S,T> void createDefaultEditHandler(
        TableColumn<S,T> column, BiConsumer<S,T> committer) {

        column.setOnEditCommit(event -> 
            committer.accept(event.getRowValue(), event.getNewValue()));

    }
}