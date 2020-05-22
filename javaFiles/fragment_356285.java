// observe item's on property and display message if it changes:
item.onProperty().addListener((obs, wasOn, isNowOn) -> {
    System.out.println(item.getName() + " changed on state from " + wasOn + " to " + isNowOn);
    if (isNowOn) {
        listView.getItems().remove(item);
    }
});