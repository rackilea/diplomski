@Override
public ResponseEntity<Page<TicketListItemResponseModel>> getTickets(
        @RequestParam(value = "page", defaultValue = "0", required = false) int page,
        @RequestParam(value = "count", defaultValue = "10", required = false) int size,
        @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
        @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
    // here you would check your request params and decide whether or not to do paging and then return what you need to return
}