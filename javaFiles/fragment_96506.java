adapter = new SimpleCursorAdapter(
            this, 
            R.layout.employee_list_item, 
            cursor, 
            new String[] {"title"},
            new int[] {R.id.title});
    employeeList.setAdapter(adapter);