@Override
public void processAdd(AddUpdateCommand cmd) throws IOException {
    if(!blacklistService.isBlackListed(cmd.getSolrInputDocument())){
       super.processAdd(cmd);
    }
}