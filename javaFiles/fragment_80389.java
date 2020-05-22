String response="{\"response\":{\"status\":1,\"count\":\"90120\"}}";
            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

 //mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true); This is for serailization time
            Wrapper wrapper = mapper.readValue(response, Wrapper.class);