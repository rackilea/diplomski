public class tableModel extends AbstractTableModel {
    //...    
    @Override
    public Student getValueAt(int rowIndex, int columnIndex) {
        Object student = data.getNode(rowIndex);
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