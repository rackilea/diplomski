@XmlRootElement
public class MyJaxbBean
{
   private String name;

   private Map<String, String> openContentMap = new HashMap<String, String>();

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @JsonAnyGetter
   public Map<String, String> getOpenContentMap()
   {
      return openContentMap;
   }

   @JsonAnySetter
   public void add(final String key, final String value)
   {
      openContentMap.put(key, value);
   }
}