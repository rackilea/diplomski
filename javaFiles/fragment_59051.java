GetCreateIssueMetadataOptions  options = new GetCreateIssueMetadataOptionsBuilder()
        .withExpandedIssueTypesFields()

        .withProjectKeys("CGIM")
        .build();
         List myList=(List) restClient.getIssueClient().getCreateIssueMetadata(options, pm); // getting the issue creation metadata relatively to the project im searching for
        java.util.Iterator<CimProject> it1=myList.iterator();
        while(it1.hasNext())
        {
                CimProject c=it1.next();
                List issueT=(List) c.getIssueTypes(); // getting the list of issue types linked to this project
                java.util.Iterator<CimIssueType> it2=issueT.iterator();
                while (it2.hasNext())
                {
                    CimIssueType issueType=it2.next();
                    System.out.print(issueType.getName());
                    Map<String, CimFieldInfo> fieldList=issueType.getFields(); // getting the list of fields linked to each issue type
                    for(Entry<String, CimFieldInfo> entry : fieldList.entrySet()) {
                        String cle = entry.getKey();
                        CimFieldInfo valeur = entry.getValue();
                        System.out.println(valeur.getName());
                    }
                }


        }