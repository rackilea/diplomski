SolrInputDocument parentDoc = new SolrInputDocument();
    parentDoc.addField("id", "parent_1");
    parentDoc.addField("name_s", "Sarah Connor");
    parentDoc.addField("blockJoinId", "1");
    solrClient.add(parentDoc);
    solrClient.commit();