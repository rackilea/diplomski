public void processPriceDiffChoice(ShipmentRow row) {
    if (row.getPriceChoice().equals("Above Price")) {
        row.setPriceEnable(false);
    } else {
        row.setPriceEnable(true);
    }
}

public void addShipmentTermsRow(ShipmentProxy proxy) {
    if (proxy.isStatus()) {
        proxy.getShipmentRowList().add(new ShipmentRow());
    } else {
        proxy.getShipmentRowList().clear();
    }
}

public void removeShipmentTermsRow(ShipmentProxy proxy,ShipmentRow row) {
    proxy.getShipmentRowList().remove(row);
}