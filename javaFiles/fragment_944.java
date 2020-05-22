@JsonView(value = StickerPackView.Admin.class)
@ApiOperation(value = "[ADMIN] Lists all categories regardless visibility", response = StickerCategory.class)
@RequestMapping(value = "/categories/all", method = RequestMethod.GET)
public ResponseEntity getCategories(Principal principal, ObjectMapper mapper) throws JsonProcessingException {
    final Collection<StickerCategory> categories = stickerService.getAllCategories();
    final String s = mapper.writeValueAsString(categories);
    return new ResponseEntity(s.length(), OK);
}