long inReplyToStatusId = -1
int counter = 0
int threadLimit = 5

while (counter < threadLimit){
    StatusUpdate statusUpdate = new StatusUpdate(Integer.toString(counter));
    statusUpdate.setInReplyToStatusId(inReplyToStatusId);

    Status updatedStatus = twitter.updateStatus(statusUpdate);
    inReplyToStatusId = updatedStatus.getId();
    counter++;
}