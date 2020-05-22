class SearchResultData {
    String source;
    String title;
    String url;
}

...

private final List<SearchResultData> dataList= new ArrayList<>();
...
Gson gson = new Gson();
SearchResultData[] data= gson.fromJson(jsonString, SearchResultData[].class);
Collections.addAll(dataList, data);