//this is your Object's holder
    ArrayList<MyExcelRowObject> myList = new ArrayList<MyExcelRowObject> ();

    //here you manipulate your rows and add them to your MyExcelRowObject objects
    for (int i = first; i <= last; i++) {
        MyExcelRowObject tmpObj = new MyExcelRowObject();
        Row row = sheet.getRow(i);
        tmpObj.setId(row.getCell(0));
        tmpObj.setType(row.getCell(1));
        tmpObj.setName(row.getCell(2));
        tmpObj.set$(row.getCell(3));

        myList.add(tmpObj);
    }

    //here is how you manipulate your List objects
    if(myList.get(0).getId().equals(myList.get(1).getId())){
        //the  ids of first and second row are the same
    }