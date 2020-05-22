// read items array
    private APIModel readItemsArray(JsonReader reader) throws IOException {
        APIModel result = new APIModel();
        String item_name, file_name, data;
        result.setResult(Util.API_001_RESULT_OK);

        reader.beginArray();
        while (reader.hasNext()) {
            item_name = "";
            file_name = "";
            data = "";
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("name")) {
                    item_name = reader.nextString();
                } else if (name.equals("file")) {
                    file_name = reader.nextString();
                } else if (name.equals("data")) {
                    data = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            result.populateModel("null", item_name, file_name, data);
        }
        reader.endArray();
        return result;
    }