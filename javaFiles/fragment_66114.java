private ListChangeListener<IDevice> getDeviceChangeListener() {
    return (javafx.collections.ListChangeListener.Change<? extends IDevice> c) -> {
        while (c.next()) {
            if (c.wasRemoved()) {
                c.getRemoved().forEach(d -> 
                    mappingList.removeIf(map -> map.getDestination().equals(d) 
                                             || map.getSource().equals(d)));
            }
        }
    };
}