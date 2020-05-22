link.add(new AjaxEventBehavior("click") {
  updateAjaxAttributes(ARA ara) {
    super.updateAttributes(ara);

    ara.getDynamicExtraParameters()
            .add("return {'q' : jQuery('#' + attrs.c).attr('testAttr') };");
  }

  onEvent(ART art) {
    RequestCycle requestCycle = RequestCycle.get();
    String val = requestCycle.getRequest()
        .getRequestParameters()
        .getParameterValue("q")
        .toString();

    // ...
  }
});