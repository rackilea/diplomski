switch (item.getItemId()) {
      case R.id.hn:
           String languageToLoad = "hi";
           LanguageUtils.shiftLanguage(this, languageToLoad);
           break;
      case R.id.eng:
           languageToLoad = "en"; // your language
           LanguageUtils.shiftLanguage(this, languageToLoad);
           break;

      default:
}