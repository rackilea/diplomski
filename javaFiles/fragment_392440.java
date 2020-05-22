public List<List<File>> getFileList(HashMap<String, List<File>> hm)
{
    List<List<File>> list = null;

    if(hm != null)
    {
        list = (ArrayList<List<File>>) hm.values();
    }

    return list;
}