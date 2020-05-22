public class StudentTableModel extends AbstractTableModel {

    public final String[] columnNames = {"First Name", "Last Name", "Major:", "GPA", "UIN", "NetID", "Age", "Gender"};
    private MyList data;

    public StudentTableModel(MyList data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    public void addStudent(Student student) {
        int row = data.size();
        System.out.println(row);
        System.out.println(student);
        data.add(student);
        fireTableRowsInserted(row, row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = data.get(rowIndex);
        if (student == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return student.getFirstName();
            case 1:
                return student.getLastName();
            case 2:
                return student.getMajor();
            case 3:
                return student.getGPA();
            case 4:
                return student.getUIN();
            case 5:
                return student.getNetID();
            case 6:
                return student.getAge();
            case 7:
                return student.getGender();
            default:
                return null;
        }
    }
}