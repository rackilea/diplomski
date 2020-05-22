String[] colNames = {"#", "Name", "Surname", "Grades", "House", "Prefect"};
DefaultTableModel model = new DefaultTableModel(colNames, 0);
Validation.newStudent(db, stringName, stringSurname); 
int maxval = Integer.parseInt(Validation.getNumberOfStudents(db)); 

for (int i = 0; i < maxval; i++)
{
    Vector<String> row = new Vector<String>();

    for (int j = 0; j < maxval; j++){

        row.add( Integer.toString(i+1) );
        row.add( Validation.listStudentNames(db).get(i) );
        row.add( Validation.listStudentSurnames(db).get(i) );
        ...
    }

    System.out.println( row ); // make sure you actually add data to the model.
    model.addRow(row); 
}

teacherContentTable.setModel(model);