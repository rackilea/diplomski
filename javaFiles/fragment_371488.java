private WTPartDescribeLink getPartlink(WTPart target) throws WTException, WTPropertyVetoException {
        WTDocument localWTDocument=null;
        if(target==null)
            return null;
        QueryResult localQueryResult=WTPartHelper.service.getDescribedByWTDocuments(target, false);
        ilogger.info("size of query result is "+localQueryResult.size());
        if((localQueryResult!=null)&&(localQueryResult.hasMoreElements()))
        {
            while(localQueryResult.hasMoreElements())
            {

                 WTObject localObject=(WTObject) localQueryResult.nextElement();
                 WTPartDescribeLink localPartlink=(WTPartDescribeLink) localObject;
                 localWTDocument=localPartlink.getDescribedBy();
            }
        }

        WTDocument docm=(WTDocument) VersionControlHelper.service.allVersionsOf(localWTDocument).nextElement();
        ilogger.info("values are "+docm.getNumber());
        String version=docm.getVersionIdentifier().getValue();
        String iteration=docm.getIterationIdentifier().getValue();
        ilogger.info("Object passing with version and iteration of"+version+"."+iteration);
        RevisionControlled localRevisionControlled=null;
        localRevisionControlled=(RevisionControlled) VersionControlHelper.service.newVersion(docm);
        localRevisionControlled=(RevisionControlled) PersistenceHelper.manager.save(localRevisionControlled);
        createLink(target,docm);
        return null;
    }

    private void createLink(WTPart spart, WTDocument localWTDocument) throws WTException {

                WTPartDescribeLink link=WTPartDescribeLink.newWTPartDescribeLink(spart, localWTDocument);
                PersistenceServerHelper.manager.insert(link);
                ilogger.info("Link saved ");

        }