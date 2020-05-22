//declare as global the dialog variable
private MaterialDialog dialog;

final MaterialSimpleListAdapter adapter = new MaterialSimpleListAdapter(new MaterialSimpleListAdapter.Callback() {
            @Override
            public void onMaterialListItemSelected(int index, MaterialSimpleListItem item) {
                dialog.dismiss();
            }
        });

        //remove the autoDismiss(true) option, better use the Activity
        //context
        dialog = new MaterialDialog.Builder(MyActivity.this)
                .adapter(adapter, null)
                .show();