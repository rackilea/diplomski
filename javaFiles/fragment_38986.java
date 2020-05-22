@XmlRootElement
public class ConfigData
{
  // This will hide the list from JAXB
  @XmlTransient
  private final List<SampleData> sampleDatas = new ArrayList<>();

  private SampleData getFirstSample()
  {
    if(sampleDatas.isEmpty())
      sampleDatas.add(new SampleData());
    return sampleDatas.get(0);
  }

  // Façade methods to delegate functionality to the list's first item...
  // Only setters are required, if you just want to read in an old format.
  // However this would not be optional, if you want to save to the new format...
  public void setName(String name)
  {
    getFirstSample().setName(name);
  }

  public void seAge(String age)
  {
    getFirstSample().setAge(age);
  }

  public void setObj(CustomObject obj)
  {
    getFirstSample().setObj(obj);
  }
}

public class SampleData
{
  private String name; 
  private String age; 
  private CustomObject obj;
  // Accessor methods...
}