private List<ListDisplay> initData() {

        DatastoreService datastore = DatastoreServiceFactory
                .getDatastoreService();

        List<ListDisplay> data = new ArrayList<ListDisplay>();

        Query query = new Query("PartyEntity");
        PreparedQuery preparedQuery = datastore.prepare(query);
        List<Entity> entities = preparedQuery.asList(FetchOptions.Builder
                .withDefaults());

        for (Entity entity : entities) {

            String PARTY_ID = (String) entity.getProperty("partyId");

            // fetch from another
            Query query2 = new Query("InsertEntity");
            Filter filterByPartyId = new Query.FilterPredicate(
                    "partyIdentifier", FilterOperator.EQUAL, PARTY_ID);
            query2.setFilter(filterByPartyId);
            PreparedQuery preparedQuery2 = datastore.prepare(query2);

            List<Entity> entities2 = preparedQuery2.asList(FetchOptions.Builder
                    .withDefaults());

            for (Entity entity2 : entities2) {
                ListDisplay display = new ListDisplay();
                display.setPartyId((String) entity.getProperty("partyId"));
                display.setPartyName((String) entity.getProperty("partyName"));
                display.setImage((BlobKey) entity.getProperty("image"));
                display.setName((String) entity2.getProperty("name"));
                display.setConstituency((String) entity2
                        .getProperty("constituency"));
                data.add(display);
            } // end loop entity2

        } // end loop entity

        return data;
    }