APIModel result = new APIModel();
        try {
            HttpResponse response;
            HttpClient myClient = new DefaultHttpClient();
            HttpPost myConnection = new HttpPost(APIParam.API_001_PRESENT(
                    serial_id, api_key));
            try {
                response = myClient.execute(myConnection);
                Reader streamReader = new InputStreamReader(response
                        .getEntity().getContent());
                JsonReader reader = new JsonReader(streamReader);
                reader.beginObject();
                while (reader.hasNext()) {

                    String name = reader.nextName();

                    if (name.equals("result")) {
                        if (reader.nextString() == "NG") {
                            result.setResult(Util.API_001_RESULT_NG);
                            break;
                        }
                    } else if (name.equals("items")) {
                        result = readItemsArray(reader);
                    } else {
                        reader.skipValue(); // avoid some unhandle events
                    }
                }

                reader.endObject();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
                result.setResult(Util.API_001_RESULT_NG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setResult(Util.API_001_RESULT_NG);
        }