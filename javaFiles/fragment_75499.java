FileHandle dirHandle;
    if (Gdx.app.getType() == ApplicationType.Android)
    {
        dirHandle = Gdx.files.internal("data");
    }
    else
    {
        dirHandle = Gdx.files.internal("./bin/data");
    }
    Array<FileHandle> handles = new Array<FileHandle>();
    getHandles(dirHandle, handles);