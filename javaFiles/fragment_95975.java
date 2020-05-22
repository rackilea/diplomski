list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(final AdapterView<?> arg0, View arg1,
                final int position, long arg3) {
            AlertDialog.Builder alert = new AlertDialog.Builder(DeleteItem.this);
            alert.setMessage("Are you sure you want to delete this?");
            alert.setCancelable(false);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ArrayAdapter yourArrayAdapter = (ArrayAdapter) arg0.getAdapter();
                    yourArrayAdapter.remove(position);
                    yourArrayAdapter.notifyDataSetChanged();
                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });


            return false;

        }
    });