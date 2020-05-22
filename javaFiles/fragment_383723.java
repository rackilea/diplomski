public class LocalizationManager {

   private static LocalizationManager mInstance = null;
   public String currentLanguage = "";
   JSONObject currentLanguageObject = new JSONObject();
   private AssetManager assetManager = BaseApplication.getInstance().getAssets(); // BaseApplication is just a class that extends Application class

   private LocalizationManager() {
   }

   public static LocalizationManager getInstance() {
       if (mInstance == null) {
           mInstance = new LocalizationManager();
       }
       return mInstance;
   }

   private boolean assetExists(String path) {
       boolean bAssetOk = false;
       try {
           InputStream stream = assetManager.open(path);
           stream.close();
           bAssetOk = true;
       } catch (IOException e) {
           e.printStackTrace();
       }
       return bAssetOk;
   }

   public String getLocalizedString(String string) {
       String language = BaseApplication.getInstance().getLanguage();
       if (!currentLanguage.equalsIgnoreCase(language)) {
           if (assetExists("localization/strings_" + language)) {
               InputStream input;
               try {
                   input = assetManager.open("localization/strings_" + language);
                   int size = input.available();
                   byte[] buffer = new byte[size];
                   input.read(buffer);
                   input.close();
                   String responseString = new String(buffer);
                   Object json;
                   try {
                       json = new JSONTokener(responseString).nextValue();
                       if (json instanceof JSONObject) {
                           currentLanguageObject = (JSONObject) json;
                           currentLanguage = language;
                           return currentLanguageObject.optString(string, string);
                       }
                   } catch (JSONException e) {
                       return string;
                   }
               } catch (IOException e) {
                   return string;
               }
           }
       } else {
           return currentLanguageObject.optString(string, string);
       }
       return string;
   }
}