import java.util.List;

public class Bing {
    private List<ColsDataset> cols;
    private List<RowsDataset> rows;

    public Bing() { }

    public void setColsDataset(List<ColsDataset> dataset) {
        this.cols = dataset;
    }

    public List<ColsDataset> getColsDataset() {
        return cols;
    }

    public void setRowsDataset(List<RowsDataset> dataset) {
        this.rows = dataset;
    }

    public List<RowsDataset> getRowsDataset() {
        return rows;
    }
}