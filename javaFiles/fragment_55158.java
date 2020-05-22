@RequestMapping(value = "/v1/items", method = RequestMethod.GET)
public ReturnResponse getItems() {

    List <Product> itemsList = itemService.getItems();

    return myDefinedUtilities.getHttpStatusResponse("success.items", HttpStatus.OK, itemsList, null);
}




@RequestMapping(value = "/v1/items", method = RequestMethod.GET, params="warehouse")
public ReturnResponse getItemsForWarehouse(@RequestParam(required = true, value = "warehouse") String wareHouseId) {

    List <Product> itemsList = itemService.getItemsForWarehouse(wareHouseId);

    return myDefinedUtilities.getHttpStatusResponse("success.items", HttpStatus.OK, itemsList, null);
}