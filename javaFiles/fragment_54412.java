this.legacy.addValueChangeListener(
    event ->
    listDataProvider
    .setFilterByValue(
        Product::getLegacy , 
        event.getValue()
    )
;