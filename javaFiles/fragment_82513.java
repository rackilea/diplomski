SolrInputDocument parentDocUpdateing = new SolrInputDocument();
    parentDocUpdateing.addField("id", "parent_1");
    parentDocUpdateing.addField("name_s", "Sarah Connor");
    parentDocUpdateing.addField("blockJoinId", "1");

    SolrInputDocument childDoc = new SolrInputDocument();
    childDoc.addField("id", "child_1");
    childDoc.addField("name_s", "John Connor");
    childDoc.addField("blockJoinId", "1");

    parentDocUpdateing.addChildDocument(childDoc);
    solrClient.add(parentDocUpdateing);
    solrClient.commit();