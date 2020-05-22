mockMvc.perform(RestDocumentationRequestBuilders.get(beerLocation)).andExpect(status().isOk())
       .andDo(document("beer-get", links(
                linkWithRel("self").ignored(),
                linkWithRel("beerapi:beer").description("The <<beers, Beer resource>> itself"),
                linkWithRel("curies").ignored()
               ),
               responseFields(
                  fieldWithPath("name").description("The name of the tasty fresh liquid"),
                  fieldWithPath("_links").description("<<beer-links,Links>> to other resources")
               )
            ));