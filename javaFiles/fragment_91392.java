RemoteRepository remote = request.getRepository();

    if ( remote != null )
    {
        path = getPathForRemoteMetadata( metadata, remote, context );
    }
    else
    {
        path = getPathForLocalMetadata( metadata );
    }

    File file = new File( getRepository().getBasedir(), path );