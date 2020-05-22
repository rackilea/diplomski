@Transactional
  public static Result fetchOptions(String strCategoryId, String strCategoryName) {

    Main mainAppModel = new Main();
    mainAppModel.populateOptions(strCategoryId, strCategoryName);
    return ok(Json.toJson(mainAppModel.toString()));
  }