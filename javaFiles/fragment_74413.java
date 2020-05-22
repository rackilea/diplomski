alertDialog.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position >= 0)
            {
                String[] list = getCurrentFileList();

                if(list[position].equals(NO_ITEMS_TEXT)){
                    return;
                }

                // If the selected file is a directory, recursively update the file list and redisplay.
                if(getCurrentFileRefList()[position].isDirectory()){
                    src = getCurrentFileRefList()[position];
                    hierarchyID ++;
                    onCreateDialog(null);
                    alertDialog.dismiss();
                }else { // If the selected item is a file, give the value to the handler and dismiss the dialog.
                    handler.handleEvent(DialogActionEventHandler.ResultID.SUBMITTED, getCurrentFileRefList()[position]);
                    alertDialog.dismiss();
                }
            }
        }
    });