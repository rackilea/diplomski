private null findAttachments(Issue issue) {
    String FieldName = "Attachment";
    Iterable<ChangelogGroup> changes = issue.getChangelog();
    StringBuilder attachments = new StringBuilder();
    StringBuilder attachmentsIDs = new StringBuilder();

    for (ChangelogGroup change: changes){
        //Multiple change items per group. 
        for(ChangelogItem item: change.getItems()){
            if(item.getField().equals(FieldName)){
                //Gets attachment name.
                attachments.append((String) item.getToString());
                //Gets attachment ID to download if needed.
                attachmentsIDs.append((String) item.getTo());
            }
        }
    }
    //Do something with attachments here..

}