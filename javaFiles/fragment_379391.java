FilterProvider filters = new SimpleFilterProvider()
            .addFilter(
                "productView", 
                SimpleBeanPropertyFilter.serializeAllExcept("similarProducts")
            );
 String res = new ObjectMapper()
            .writer(filters)
            .writeValueAsString(product);
 System.out.println(res);