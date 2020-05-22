private MediaDO mediaDO;

public UserDataException(String message, MediaDO mediaDO, final Throwable throwable) {
    super(DKERROR + message, throwable);
    this.mediaDO = mediaDO;
}

public MediaDO getMediaDO()
{
    return mediaDO;
}