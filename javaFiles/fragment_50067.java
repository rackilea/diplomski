lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            data.remove(position);
            db.deleteRecipe(id + 1);
           data = db.getAllRecipe();
adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, data);
//and call change adapter in listview
            adapter.notifyDataSetChanged();

            return false;

           // db.deleteRecipeRow(r.getRecipeID());
            //Toast.makeText(getActivity(),"ID = " + r.getRecipeID(),   Toast.LENGTH_LONG).show();

        }
    });