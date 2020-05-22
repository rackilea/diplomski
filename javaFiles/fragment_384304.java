Response response = RULE.client().target("http://localhost:" + RULE.getLocalPort() + "/people")
        .request()
        .post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));
assertEquals(200, response.getStatus());
Person newPerson = response.readEntity(Person.class);
....