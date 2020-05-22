verify(orderService).createOrder(
      org.mockito.Matchers.<CreateOrderEvent>argThat(
        org.hamcrest.Matchers.<CreateOrderEvent>hasProperty("details",
          allOf(
            hasProperty("dateTimeOfSubmission", notNullValue()),
            hasProperty("name", equalTo(CUSTOMER_NAME)),
            hasProperty("address1", equalTo(ADDRESS1)),
            hasProperty("postcode", equalTo(POST_CODE)))
    )));