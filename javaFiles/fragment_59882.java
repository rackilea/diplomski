import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Student student = new Student("Skywalker", "Luke", 0, true, true);
                StudentTabelModel leftModel = new StudentTabelModel(student);
                StudentTabelModel rightModel = new StudentTabelModel(student);

                JTable leftTable = new JTable(leftModel);
                leftTable.setGridColor(Color.GRAY);
                JTable rightTable = new JTable(rightModel);
                rightTable.setGridColor(Color.GRAY);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 2));
                frame.add(new JScrollPane(leftTable));
                frame.add(new JScrollPane(rightTable));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class StudentTabelModel extends AbstractTableModel {

        private List<Student> students = new ArrayList<>(25);
        private PropertyChangeListener propertyChangeListener;

        public StudentTabelModel(Student... students) {
            propertyChangeListener = new StudentPropertyChangeListener();
            add(students);
        }

        public void add(Student... students) {
            if (students != null && students.length > 0) {
                int startRow = this.students.size();
                for (Student student : students) {
                    student.addPropertyChangeListener(propertyChangeListener);
                    this.students.add(student);
                }
                fireTableRowsInserted(startRow, this.students.size() - 1);
            }
        }

        public void remove(Student ...students) {
            if (students != null && students.length > 0) {
                for (Student student : students) {
                    int index = this.students.indexOf(student);
                    if (index != -1) {
                        student.removePropertyChangeListener(propertyChangeListener);
                        this.students.remove(student);
                        fireTableRowsDeleted(index, index);
                    }
                }
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                case 1:
                    return String.class;
                case 2:
                case 3:
                    return Integer.class;
                case 4:
                case 5:
                    return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student student = students.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.getLastName();
                case 1:
                    return student.getFirstName();
                case 2:
                    return student.getGrade();
                case 3:
                    return student.getTable();
                case 4:
                    return student.getGender();
                case 5:
                    return student.getAvailable();
            }
            return "??";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Student student = students.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    student.setLastName(aValue == null ? null : aValue.toString());
                    break;
                case 1:
                    student.setFirstName(aValue == null ? null : aValue.toString());
                    break;
                case 2:
                    if (aValue instanceof Integer) {
                        student.setGrade((Integer) aValue);
                    }
                    break;
                case 3:
                    if (aValue instanceof Integer) {
                        student.setTable((Integer) aValue);
                    }
                    break;
                case 4:
                    if (aValue instanceof Boolean) {
                        student.setGender((Boolean) aValue);
                    }
                    break;
                case 5:
                    if (aValue instanceof Boolean) {
                        student.setAvailable((Boolean) aValue);
                    }
                    break;
            }
        }

        protected class StudentPropertyChangeListener implements PropertyChangeListener {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getSource() instanceof Student) {
                    Student student = (Student) evt.getSource();
                    int row = students.indexOf(student);
                    if (row != -1) {
                        switch (evt.getPropertyName()) {
                            case "lastName":
                                fireTableCellUpdated(row, 0);
                                break;
                            case "firstName":
                                fireTableCellUpdated(row, 1);
                                break;
                            case "grade":
                                fireTableCellUpdated(row, 2);
                                break;
                            case "table":
                                fireTableCellUpdated(row, 3);
                                break;
                            case "gender":
                                fireTableCellUpdated(row, 4);
                                break;
                            case "avaliable":
                                fireTableCellUpdated(row, 5);
                                break;
                        }
                    }
                }
            }

        }

    }

    public class Student {

        private String lastName;
        private String firstName;
        private int grade;
        private int table;
        private boolean gender;//Male=true, female=false;
        private boolean available; //true=available;

        private PropertyChangeSupport propertyChangeSupport;

        public Student() {
            this("", "", 0, false, true);
        }

        public Student(String l, String f, int i, boolean g, boolean a) {

            lastName = l;
            firstName = f;
            grade = i;
            gender = g;
            available = a;
            //table is not written back to the txt.
            table = 0;
            propertyChangeSupport = new PropertyChangeSupport(this);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.removePropertyChangeListener(listener);
        }
//Getters

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public int getGrade() {
            return grade;
        }

        public int getTable() {
            return table;
        }

        public boolean getGender() {
            return gender;
        }

        public boolean getAvailable() {
            return available;
        }

//Setters
        public void setLastName(String s) {
            String old = lastName;
            this.lastName = s;
            propertyChangeSupport.firePropertyChange("lastName", old, lastName);
        }

        public void setFirstName(String s) {
            String old = firstName;
            firstName = s;
            propertyChangeSupport.firePropertyChange("firstName", old, firstName);
        }

        public void setGrade(int i) {
            int old = grade;
            grade = i;
            propertyChangeSupport.firePropertyChange("grade", old, grade);
        }

        public void setTable(int hiahia) {
            int old = table;
            table = hiahia;
            propertyChangeSupport.firePropertyChange("table", old, table);
        }

        public void setGender(boolean b) {
            boolean old = gender;
            gender = b;
            propertyChangeSupport.firePropertyChange("gender", old, gender);
        }

        public void setAvailable(boolean b) {
            boolean old = available;
            available = b;
            propertyChangeSupport.firePropertyChange("available", old, available);
        }

//Miscellaneous
        @Override
        public String toString() {
            String a = "";

            a = lastName + "," + firstName + "," + Integer.toString(grade) + "," + Boolean.toString(gender) + "," + Boolean.toString(available);
            return a;
        }
    }
}