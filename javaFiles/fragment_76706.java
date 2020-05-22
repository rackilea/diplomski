/*
* Stores the current Thread in the PhotoTask instance,
*  that the instance
* can interrupt the Thread.
*/
try {
Translation translation =
translate.translate(
MY_STRING,
Translate.TranslateOption.sourceLanguage("en"),
Translate.TranslateOption.targetLanguage("ar"));
parseObject.put("data0", translation.getTranslatedText());
} catch (Exception e) {
parseObject.put("data0", MY_STRING + " " + mContext.getString(R.string.translationfailed));
}

/*English to Chinese*/
 try {
Translation
translation =
translate.translate(
MY_STRING,
Translate.TranslateOption.sourceLanguage("en"),
Translate.TranslateOption.targetLanguage("zh-CN"));
parseObject.put("data1", translation.getTranslatedText());
} catch (Exception e) {
parseObject.put("data1", MY_STRING + " " + mContext.getString(R.string.translationfailed));
}

}
}