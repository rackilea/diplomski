private WebMarkupContainer createListViewContainer (String id) {
    LOG.info("-- CreateListViewContainer");

    listViewContainer = new WebMarkupContainer(id);
    listViewContainer.setOutputMarkupId(true);
    listViewContainer.add(createSortableBehavior());

    List<String> liste = Arrays.asList("Node A", "Node B", "Node C");
    ListView<String> listView = createListView("listItem", liste);

    listViewContainer.add(listView);

    return listViewContainer;
}