ListViewDialogFragment fragment = ListViewDialogFragment.newInstance("Your_Title", new ListViewDialogFragment.MyCallback(){
        @Override
        public void callback(String name, String flag){
            //Do whatever you want with the name and flag.
            //You can create a ListItem with these 2 and update your adapter.
        }
    });
    fragment.show(getFragmentManager(), "");