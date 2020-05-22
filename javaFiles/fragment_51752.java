/**
 * Gets distinct resultlist from grouped query
 * 
 * @param query
 * @return results list
 * @throws SolrServerException 
 */
public SolrDocumentList queryGrouped(SolrQuery query) throws SolrServerException {


    List<GroupCommand> groupCommands = this.solr.query(query).getGroupResponse().getValues();

    GroupCommand groupCommand = groupCommands.get(0);

    List<Group> groups = groupCommand.getValues();

    SolrDocumentList list = new SolrDocumentList();

    if(groups.size() > 0){

        long totalNumFound = groupCommand.getNGroups();

        int iteratorLimit = 1;

        for(Group g : groups){
            SolrDocumentList groupList = g.getResult();

            list.add(groupList.get(0));   

            //I wanted to limit list to 10 records    
            if(iteratorLimit++ > 10){
                break;
            }
        }

        list.setNumFound(totalNumFound);


    }

    return list;

}