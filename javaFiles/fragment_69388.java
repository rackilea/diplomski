@Inject
public void setActionMapper(ActionMapper actionMapper) {
  this.actionMapper = actionMapper;
}

private UrlHelper urlHelper;

@Inject
public void setUrlHelper(UrlHelper urlHelper) {
  this.urlHelper = urlHelper;
}