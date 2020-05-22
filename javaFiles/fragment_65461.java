Configuration.Builder configurationBuilder = new Configuration.Builder(this);
    configurationBuilder.addModelClasses(Test.class);
    configurationBuilder.addModelClasses(ShoppingList.class);
    configurationBuilder.addModelClasses(ShoppingListItem.class);
    configurationBuilder.addModelClasses(ArticleInfoModel.class);

    ActiveAndroid.initialize(configurationBuilder.create());