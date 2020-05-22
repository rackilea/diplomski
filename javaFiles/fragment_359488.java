public class MyTableModel extends AbstractTableModel {

    private List<Staff> staffs;

    public MyTableModel(List<Staff> staffs){
        this.staffs = staffs;
    }

    @Override
    public int getRowCount() {
        return staffs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public void add(Staff staff) {
        int size = getSize();
        staffs.add(staff);
        fireTableRowsInserted(size, size);
    }

    public void remove(Staff staff) {
        if (staffs.contains(staff) {
            int index = stafff.indexOf(staff);
            staffs.remove(staff);
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Staff staff = staffs.get(rowIndex);
        switch (columnIndex){
            case 0:
                return staff.getName();
            case 1:
                return staff.getSurname();
            case 2:
                return staff.getDate();
            case 3:
                return staff.getPosition();
            case 4:
                return staff.getSalary();
        }
        return "";
    }
}