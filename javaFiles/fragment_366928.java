ClientResponse response = webResource.path("Orders")
        .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        .accept(MediaType.APPLICATION_JSON_TYPE)
        .post(ClientResponse.class, formData);

Order order = new Gson().fromJson(response.getEntity(String.class), Order.class);