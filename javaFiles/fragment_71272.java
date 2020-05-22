@InitBinder(value = { INVALIDATE_ITEM_PARAM })
protected void initInvalidateItemBinder(WebDataBinder binder) {
  DefaultBindInitializer.initBinder(binder);
  binder.setAllowedFields("expireDate", "comment");
  binder.setValidator(validator);
}