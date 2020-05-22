MamManager manager = MamManager.getInstanceFor(connection);
MamManager.MamQueryResult r = manager.mostRecentPage([userBareJID], [numberOfMessages]);
if (r.forwardedMessages.size() >= 1) //printing first of them
{
    Message message = (Message) r.forwardedMessages.get(0).getForwardedStanza();
    Log.i("mam", "message received" + message.getBody());
}