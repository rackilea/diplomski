public PublishAction getLatestRecordonBasedID(int tcmURI,int pubID) throws StorageException
{
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("from PublishAction pb where pb.ITEM_REFERENCE_ID = :tcmURI and pb.PUBLICATION_ID = :pubID order by pb.LAST_PUBLISHED_DATE desc");

    Map<String, Object> queryParams = new HashMap<String, Object>();   
    queryParams.put("tcmURI", tcmURI);
    queryParams.put("pubID", pubID);

    final List<PublishAction> myActions = executeQueryListResult(queryBuilder.toString(), queryParams, 1);

    if (myActions != null && !myActions.isEmpty()) 
    {
        StringBuilder queryBuilderFinal = new StringBuilder();
        queryBuilderFinal.append("select pa from PublishAction pa where pa.id=:myId");

        Map<String, Object> queryParamsFinal = new HashMap<String, Object>();   
        queryParamsFinal.put("myId", myActions.get(0).getId()); 
        return executeQuerySingleResult(queryBuilderFinal.toString(), queryParamsFinal);
    }
    else 
    {
        return null;
    }
}