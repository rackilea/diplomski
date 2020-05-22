Product child1 = new Product();
child1.id = 2;
child1.name = "sfd";
Product grandchild1 = new Product();
grandchild1.id = 4;
grandchild1.name = "werrwe";
child1.similarProducts = Collections.singletonList(grandchild1);
Product child2 = new Product();
child2.id = 2;
child2.name = "sfd";

Product product = new Product();
product.id = 1;
product.name = "product";

product.similarProducts = Arrays.asList(child1, child2);

FilterProvider filters = new SimpleFilterProvider().addFilter("productView",
            SimpleBeanPropertyFilter.serializeAllExcept("similarProducts"));

String res = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
            .writer(filters)
            .writeValueAsString(product);

System.out.println(res);