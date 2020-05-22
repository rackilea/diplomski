for (int i = 0; i < employeeCount; i++)
{
    TableItem item; 
    Button radio; 
    TableEditor editor; 

    item = new TableItem(table, SWT.NO_FOCUS);

    item.setText(0, employees[i]); //Let's assume you have an array of employees' names

    radio = new Button(table, SWT.RADIO);
    //TODO: setup your radiobutton here (text, behavior, etc.)
    editor = new TableEditor(table);
    editor.setEditor(radio, item, 1); //1 is the column index (excellent)
    editor.layout();

    radio = new Button(table, SWT.RADIO);
    //TODO: setup your radiobutton here (text, behavior, etc.)
    editor = new TableEditor(table);
    editor.setEditor(radio, item, 2); //2 is the column index (good)
    editor.layout();

    radio = new Button(table, SWT.RADIO);
    //TODO: setup your radiobutton here (name, text, behavior, etc.)
    editor = new TableEditor(table);
    editor.setEditor(radio, item, 3); //3 is the column index (average)
    editor.layout();

    radio = new Button(table, SWT.RADIO);
    //TODO: setup your radiobutton here (text, behavior, etc.)
    editor = new TableEditor(table);
    editor.setEditor(radio, item, 4); //4 is the column index (poor)
    editor.layout();
}