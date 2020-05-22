IndicesAdminClient adminClient = searchConnection.client.admin().indices();
String indexName = "location";
DeleteIndexResponse delete = adminClient.delete(new DeleteIndexRequest(indexName)).actionGet()
if (!delete.isAcknowledged()) {
    log.error("Index {} wasn't deleted", indexName);
}