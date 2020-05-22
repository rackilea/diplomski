objectIDCustomTypeAdapter = new CustomTypeAdapter<Integer>() {
      @Override public Integer decode(CustomTypeValue value) {
        try {
          return Integer.parseInt(value.toString());
        } catch (Exception e) { //NumberFormatException
          e.printStackTrace()
        }
      }

      @Override public CustomTypeValue encode(Integer value) {
        //assumption; I am not sure about the `Number` part
        return new CustomTypeValue.GraphQLNumber(value);
      }
    };

ApolloClient.builder()
  .serverUrl(serverUrl)
  .okHttpClient(okHttpClient)
  //ObjectId changes to all caps
  .addCustomTypeAdapter(CustomType.OBJECTID, objectIDCustomTypeAdapter) 
  .build();