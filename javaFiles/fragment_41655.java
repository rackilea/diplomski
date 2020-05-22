private void loadData() {

        if (initialStart) {
            SharedPreferences sharedPreferences = getSharedPreferences("todo list", MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("task_list", null);
            Type type = new TypeToken<ArrayList<Record>>() {
            }.getType();

            AddItemActivity.listItems = gson.fromJson(json, type);
            initialStart = false;
        }
        if (AddItemActivity.listItems == null) {
            AddItemActivity.listItems = new ArrayList<>();
        }

        if (adapter == null) {
            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, AddItemActivity.listItems);
        }
        adapter.notifyDataSetChanged();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("todo list", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(AddItemActivity.listItems);
        editor.putString("task_list", json);
        editor.apply();
    }