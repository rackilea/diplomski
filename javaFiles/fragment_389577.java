private static final TAG = "TheNameOfYourActivity";

private void loadDataFromResourceFile(){
    Resources res = getResources();
    InputStream is= res.openRawResource(R.raw.test02);

    Scanner scanner = new Scanner(is);
    StringBuilder builder = new StringBuilder();
    while(scanner.hasNextLine()){
        builder.append(scanner.nextLine());
    }

    String result = builder.toString();
    if(!result.isEmpty()){
        parseJson(result);
        // Just show the first 250 characters of the string!! 3999 "character" elements is quite a bit
        Log.e(TAG, "The contents of my resource file = "  + result.substring(0,250));
    }
    else{
        Log.e(TAG, "My resource file  is empty");
    }
}