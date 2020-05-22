f.language.value.get.toUpperCase.split(",").map {
  try {
    JavaLanguageEnum.valueOf(_)
  } catch {
    case e: IllegalArgumentException => JavaLanguageEnum.ALL
  }
}