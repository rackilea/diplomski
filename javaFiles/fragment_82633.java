public void loadTreeItems()
{


    TreeItem<String> root = new TreeItem<String>("Root");

    root.setExpanded(true);

    TreeItem<String> model1 = new TreeItem<String>("Model1");
    TreeItem<String> model2 = new TreeItem<String>("Model2");

    TreeItem<String> model11 = new TreeItem<String>("Model1.1");
    TreeItem<String> model12 = new TreeItem<String>("Model1.2");

    root.getChildren().add(model1);
    root.getChildren().add(model2);

    model1.getChildren().add(model11);
    model1.getChildren().add(model12);

    locationTreeView.setRoot(root);
}