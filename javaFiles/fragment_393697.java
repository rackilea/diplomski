public static void main(String[] args)
{
  List<String> domainList = new ArrayList<>(Arrays.asList("gmail","yahoo","yahoo","aol"));
  List<String> flagList = new ArrayList<>(Arrays.asList("Y","N","N","N"));

  Set<String> seen = new HashSet<String>();
  Iterator<String> di = domainList.iterator();
  Iterator<String> fi = flagList.iterator();
  while(di.hasNext() && fi.hasNext())
  {
    fi.next(); // don't care about result
    String domain = di.next();
    if(!seen.add(domain)) 
    {
      di.remove();
      fi.remove();
    }
  }    
  System.out.println(domainList);
  System.out.println(flagList);
}