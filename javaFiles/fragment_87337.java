for(Device d : devices) {
    Collection<Device> selected = manufacturerIndex.get(d.getManufacturer());
    if (selected == null) {
         selected = new ArrayList<Device>();
         manufactuerIndex.put(d.getManufacturer(), selected);
    }
    selected.add(d);
    // the same for the second index
}