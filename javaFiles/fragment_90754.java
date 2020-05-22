private List<TagPojo> filters = new ArrayList<>();

@Override
public void onFilterSelected(TagPojo item) {
    filters.add(item);
    String[] filterIds = filters.stream().map(f -> f.getId()).toArray(size -> new String[size]);
    UpdateStuffList(list.where()
        .in("tagList.id", filterIds )
        .findAllAsync());
}

@Override
public void onFilterDeselected(TagPojo item) {
    // need to have a proper TagPojo.equals() for this
    filters.remove(item);
}