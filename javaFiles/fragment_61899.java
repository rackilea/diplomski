Vector <Object> headings = new Vector <Object>();       
Vector <Vector<Object>> data = new Vector <Vector<Object>> ();

headings = acquire.Account("StudentHeader");   

for(int i = 0 ; i < yourStudentDataNumber ; i++) {
    Vector <Object> dataElement = new Vector <Object>();
    dataElement = acquire.Account("StudentHeader"); 
    //i don't know what is acquire object, this for loop is only an example
    // however you need to build a Vector<Object> for each row of the table

    data.add(dataElement);
}       

Object[] ids = headings.toArray();

int numberOfRow = data.size();     

Object[][] bidimArray = new Object[numberOfRow][];      

for(int i = 0 ; i < numberOfRow ; i++) {
    bidimArray[i] = data.get(i).toArray();
}

DefaultTableModel model = new DefaultTableModel(bidimArray, ids);