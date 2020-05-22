java.lang.reflect.Type listType = new TypeToken<ArrayList<BDetails>>() {
                }.getType();

        List<BDetails> bList = new Gson().fromJson(json, listType);

        DefaultTableModel model = (DefaultTableModel) pTable.getModel();
        model.setRowCount(0);

        for( BDetails adr : bList) 
        {

            Vector<String> row = new Vector<String>();
            row.add(detail.getUserName());
            row.add(detail.getFirstName());
            row.add(detail.getLastName());
            row.add(detail.getAddress();
            model.addRow( row );
        }