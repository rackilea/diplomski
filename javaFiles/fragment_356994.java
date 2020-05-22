final AlertDialog.Builder builder = new AlertDialog.Builder(AddExpenseActivity.this);
        builder.setTitle( "Select Income Category" );

        String[] catNames = new String[categories.size()];
        for (int i=0; i<categories.size(); i++ ){
            catNames[i] = categories.get(i).getName();
        }

        builder.setItems( catNames, new DialogInterface.OnClickListener() {....