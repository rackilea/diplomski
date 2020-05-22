Message msg = inbox.getMessage(j);
msg.setFlag(Flags.Flag.DELETED, true);
if (msg.isSet(Flags.Flag.DELETED))
{
    inbox.close(true);
    return true;
}