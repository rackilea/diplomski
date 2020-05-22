[Serializable]
public class BlogGadgetDto 
{
  public int GadgetId {get;set;}
  public BlogSmallDto Blog {get;set;}
  // and so on
}

[Serializable]
public class BlogSmallDto 
{
  public int BlogId {get;set;}
  public string BlogName {get;set;}
  // and so on
}