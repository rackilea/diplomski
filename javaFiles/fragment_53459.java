UUID uuid = UUID.fromString("cc59cdbf-aad4-4cd1-a4f0-e7819c56b884");
    ExtendedPropertyDefinition epd = new ExtendedPropertyDefinition(uuid, "NamaId", MapiPropertyType.String);

    ItemView view2 = new ItemView(3);
    SearchFilter sf = new SearchFilter.IsEqualTo(epd,"isiId");
    FindItemsResults<Item> fir = service.findItems(WellKnownFolderName.SentItems, sf, view2);
    for (Item itm : fir.getItems()){
        System.out.println(itm.getId());
        System.out.println(itm.getSubject());  
    }