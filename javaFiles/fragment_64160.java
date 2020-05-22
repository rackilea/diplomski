public void testDelete () {

    Menu menu = new menu(); 
    menu.setmenuId("bacalla-amb-tomaquet");

    MenuPrice menuPrice = new menuPrice(menu);
    menuPrice.setPrice((float)20.0);

    // Not needed
    // menuPriceService.save(menuPrice);

    // Add menuPrice to menu's menuPrice set
    menu.menuPrice.add(menuPrice);

    MenuPriceSummary menuPriceSummary = new menuPriceSummary(menu);
    menuPriceSummary.setFortnightlyAvgPrice((float)20.0);

    // Set menuPriceSummary in menu        
    menu.summary = menuPriceSummary;

    // Not needed
    //menuPriceSummaryService.save(menuPriceSummary);

    // Saving menu will save it children too
    menuService.save(menu);

    menu = menuService.findBymenuId("bacalla-amb-tomaquet");

    assertNotNull (menu);

    menuService.delete (menu);

    menu = menuService.findBymenuId("bacalla-amb-tomaquet");

    assertNull (menu);

}