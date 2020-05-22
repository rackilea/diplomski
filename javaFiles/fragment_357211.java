AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add New Task")
                .setMessage("what do you want to do next")
                .setView(R.layout.custom_view)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final EditText text = ((AlertDialog)dialog).findViewById(R.id.editText);
                        String task;
                        task = text.getText().toString();

                        dbHelper.insertNewTask(task);
                        if(getFragmentRefreshListener()!=null) {
                            getFragmentRefreshListener().onRefresh();
                        }
                        loadTaskList();
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        dialog.show();