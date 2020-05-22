ArrayList <String> list = new ArrayList<String>( ) ;

        //List<String> myList = new ArrayList<String>(Arrays.asList(s.split(",")));

        list.addAll(new ArrayList<String>(Arrays.asList(cursor.getColumnNames()))); // not getColumnNames() need use here;
        adapter.updateList(  list );