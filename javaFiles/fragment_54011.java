private void Parsing(JsonParser jsonParser) {
    Log.i(">>>ClassResponseloc", "" + jsonParser);
    mList = new ArrayList<Model>();
    Model classModel = null;

    try {
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            classModel = new JobSearchModel();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("id".equals(fieldName)) {
                    jsonParser.nextToken();
                    classModel.setId((jsonParser.getText()) + "-");
                } else if ("name".equals(fieldName)) {
                    jsonParser.nextToken();
                    classModel.setDescription(jsonParser.getText());
                }
            }

            mList.add(classModel);

        }

        SpinnerCustomAdapter adapter = new SpinnerCustomAdapter(this, mList);
        loc.setAdapter(adapter);

    } catch (JsonParseException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}