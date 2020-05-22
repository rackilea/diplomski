public class NewsFeedItemTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!NewsFeedItem.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        TypeAdapter<JsonElement> jsonElementAdapter = gson.getAdapter(JsonElement.class);
        TypeAdapter<NewsFeedArticle> newsFeedArticleAdapter = gson.getDelegateAdapter(this, TypeToken.get(NewsFeedArticle.class));
        TypeAdapter<NewsFeedAd> newsFeedAdAdapter = gson.getDelegateAdapter(this, TypeToken.get(NewsFeedAd.class));

        return (TypeAdapter<T>) new NewsFeedItemTypeAdapter(jsonElementAdapter, newsFeedArticleAdapter, newsFeedAdAdapter).nullSafe();
    }

    private static class NewsFeedItemTypeAdapter extends TypeAdapter<NewsFeedItem> {

        private final TypeAdapter<JsonElement> jsonElementAdapter;
        private final TypeAdapter<NewsFeedArticle> newsFeedArticleAdapter;
        private final TypeAdapter<NewsFeedAd> newsFeedAdAdapter;

        NewsFeedItemTypeAdapter(TypeAdapter<JsonElement> jsonElementAdapter,
                TypeAdapter<NewsFeedArticle> newsFeedArticleAdapter,
                TypeAdapter<NewsFeedAd> newsFeedAdAdapter) {
            this.jsonElementAdapter = jsonElementAdapter;
            this.newsFeedArticleAdapter = newsFeedArticleAdapter;
            this.newsFeedAdAdapter = newsFeedAdAdapter;
        }

        @Override
        public void write(JsonWriter out, NewsFeedItem value) throws IOException {
            if (value.getClass().isAssignableFrom(NewsFeedArticle.class)) {
                newsFeedArticleAdapter.write(out, (NewsFeedArticle) value);

            } else if (value.getClass().isAssignableFrom(NewsFeedAd.class)) {
                newsFeedAdAdapter.write(out, (NewsFeedAd) value);

            }

        }

        @Override
        public NewsFeedItem read(JsonReader in) throws IOException {
            JsonObject objectJson = jsonElementAdapter.read(in).getAsJsonObject();

            if (objectJson.has("Title")) {
                return newsFeedArticleAdapter.fromJsonTree(objectJson);

            } else if (objectJson.has("CampaignName")) {
                return newsFeedAdAdapter.fromJsonTree(objectJson);
            }

            return null;
        }
    }
}