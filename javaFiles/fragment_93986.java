private void populateScoreMap(String toConvert)
{
    Gson gson = new GsonBuilder().create();
    Type collectionType = new TypeToken<SortedMap<Integer, Integer>>(){}.getType();

    ScoreRecord.scoreMap = gson.fromJson(toConvert, collectionType);
}