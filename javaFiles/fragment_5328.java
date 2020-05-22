public void retrieveInformation(BackendlessDataQuery query,final DefaultTableModel model){
    System.out.println("Retrieving Data...");
    Backendless.Data.of(Contact.class).find(query, new AsyncCallback<BackendlessCollection<Contact>>() {

        @Override
        public void handleResponse(BackendlessCollection<Contact> backendlessCollection) {


             Object[] row = new Object[2];
             for (Contact map : backendlessCollection.getCurrentPage()){
                 row[0] = map.getName();
                 row[1] = map.getNumber();
                 model.addRow(row);
                 System.out.println("Retrieving Data complete !");
             }


        }

        @Override
        public void handleFault(BackendlessFault backendlessFault) {
            System.out.println(backendlessFault.getMessage());
        }
    });}