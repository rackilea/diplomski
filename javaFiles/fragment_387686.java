public static Date getLastPublishedDate(CmsJspActionElement cms, CmsResource resource) throws Exception {
    CmsObject cmso = cms.getCmsObject();
    String sitePath = cmso.getSitePath(resource);

    if (cmso.readAllAvailableVersions(sitePath).size() > 0) {
        I_CmsHistoryResource histRes = cmso.readAllAvailableVersions(sitePath).get(0);
        int publishTag = histRes.getPublishTag();
        CmsHistoryProject project = cmso.readHistoryProject(publishTag);            
        return new Date(project.getPublishingDate());                                   
    } else {
        return null;
    }   
}