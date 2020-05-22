package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTabeGetRowsFromTable {

    static String []columnNames = {
        "Name",
        "Age",
        "Country"
    } ;
    Vector<Student> students = new Vector<Student> () ;

    Vector<Student> buildInitialData (){
        students.add(new Student("X", 18, "US")) ;
        students.add(new Student("Y", 19, "US")) ;
        students.add(new Student("Z", 20, "US")) ;

        return students ;
    }

    Student getNewStudent (){
        return new Student("A", 21, "Canada", true) ;
    }

    protected void buildAndGetTableData (){
        JTable table = new JTable () ;

        CustomTableModel ctm = new CustomTableModel(buildInitialData()) ;
        ctm.setColumnIdentifiers(columnNames);
        table.setModel (ctm) ;


        JFrame frame = new JFrame () ;
        frame.add(new JScrollPane(table), BorderLayout.CENTER) ;

        JButton btnAddRow = new JButton ("Add Row");
        btnAddRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ctm.addARow(getNewStudent());
            }
        });
        frame.add(btnAddRow, BorderLayout.SOUTH);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static class Student {
        String name;
        int age;
        String country ;
        boolean addedLater = false;

        public Student (String name, int age, String country){
            this(name, age, country, false) ;
        }

        public Student (String name, int age, String country, boolean addedLater){
            this.name = name ;
            this.age = age ;
            this.country = country ;
        }
    }



    private class CustomTableModel extends DefaultTableModel{

        /**
         * 
         */
        private static final long serialVersionUID = -8119518861817992201L;

        private Vector<Student> data ;

        public CustomTableModel (Vector<Student> data){
            this.data = data ;
        }

        @Override
        public Object getValueAt(int row, int column) {
            if (data != null && row < data.size()){
                Student student = (Student)data.get(row) ;
                switch (column){
                case 0:
                    return student.name ;
                case 1:
                    return student.age ;
                case 2:
                    return student.country;
                default:
                    return null ;

                }
            }

            return null ;
        }

        @Override
        public int getRowCount() {
            if (data != null){
                return data.size();
            }
            return 0 ;
        }

        public void addARow (Student student){
            data.add(student) ;
            fireTableDataChanged();
        }
    }

    public static void main (String args[]){
        JTabeGetRowsFromTable test = new JTabeGetRowsFromTable () ;
        test.buildAndGetTableData();
    }

}