public void getHandles(FileHandle begin, Array<FileHandle> handles)
{
    FileHandle[] newHandles = begin.list();
    for (FileHandle f : newHandles)
    {
        if (f.isDirectory())
        {
            Gdx.app.log("Loop", "isFolder!");
            getHandles(f, handles);
        }
        else
        {
            Gdx.app.log("Loop", "isFile!");
            handles.add(f);
        }
    }
}