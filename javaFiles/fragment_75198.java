public SomeClass
{
    public List<HeaderInfo> getHeaderInfos()
    {
         List<String> labels = getAllLabels();
         List<HeaderInfo> headerInfos = new ArrayList<HeaderInfo>();
         for(String label : labels)
         {
             headerList.add(new HeaderInfo(label));
         }
         return headerInfos;
    }
}