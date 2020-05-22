new ACLProvider() {
    @Override
    public List<ACL> getDefaultAcl () {
        return ZooDefs.Ids.CREATOR_ALL_ACL;
    }

    @Override
    public List<ACL> getAclForPath (String path){
        return ZooDefs.Ids.CREATOR_ALL_ACL;
    }
}