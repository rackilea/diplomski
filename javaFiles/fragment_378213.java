@Override
    public void onGetCategories(CategoriesModel categoriesModel) {
        isLoading = false;
        dataItems = categoriesModel.getData();
        dataItems.add(0, ee);
        setAdapter();

    }