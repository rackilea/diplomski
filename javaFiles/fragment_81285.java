@RequestMapping(value = "/{productId}/freeTrial", method = RequestMethod.GET)
  @ResponseBody
  public String retrieveServiceFreeTrialsByProductIdWithParam(
      @PathVariable String productId,
      @RequestParam(value = "addFields", required = false) String[] addFields) {

    List<String> addFieldsList = new ArrayList<>();
    if(addFields!=null)
      addFieldsList = Arrays.asList(addFields);  

    boolean isIncludeDeleted = addFieldsList.contains("includeDeleted");
    boolean isOnlyActive = addFieldsList.contains("onlyActive");

    // here you define your algorithm
    boolean b = isIncludeDeleted && isOnlyActive;

    return retrieveFreeTrialsActivity().retrieveFreeTrialsByProductId(productId, b);
  }