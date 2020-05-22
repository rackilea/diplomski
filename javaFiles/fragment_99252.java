import java.util.ArrayList;

public class Worksheet {
    private ArrayList<DataEntry> data;
    private String title;

    /**
     * create a new worksheet with given title
     *
     * @param title
     */
    public Worksheet(String title) {
        data = new ArrayList<DataEntry>();
        this.title = title;
    }

    /**
     * @return a shallow copy of the data
     */
    public ArrayList<DataEntry> getData() {
        return data;
    }

    /**
     * @return title of the worksheet
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param row
     * @param column
     * @return value of item at given row and column (if any), null otherwise
     */
    public Double get(int row, int column) {

        Double retVal = null;
        for (DataEntry dataEntry : data) {
            if (dataEntry.getColumn() == column && dataEntry.getRow() == row) {
                retVal = dataEntry.getValue();
            }
        }
        return retVal;
    }

    /**
     * set the value of DataEntry object at given row and column to given value
     * <p>
     * if a DataEntry object for given row and column already exists, overwrite the current value
     * if a DataEntry object for given row and column doesn't exist, add a new DataEntry object
     * with given row, column, value to the list.
     *
     * @param row
     * @param column
     * @param val
     */
    public void set(int row, int column, double val) {
        boolean isNew = true;
        for (DataEntry dataEntry : data) {
            if (dataEntry.getColumn() == column && dataEntry.getRow() == row) {
                dataEntry.setValue(val);
                isNew = false;
            }
        }
        if (isNew) {
            DataEntry newData = new DataEntry();
            newData.setColumn(column);
            newData.setRow(row);
            newData.setValue(val);
            data.add(newData);

        }

    }

    /**
     * @param row
     * @param column
     * @return index of DataEntry object in list data with given row and column
     * return -1 if no such DataEntry object found
     */
    public int indexOf(int row, int column) {
        Double value = this.get(row, column);
        if (value != null) {
            for (DataEntry dataEntry : data) {
                if (dataEntry.getColumn() == column && dataEntry.getRow() == row) {
                    return data.indexOf(dataEntry);
                }
            }
        }
        return -1;
    }
}