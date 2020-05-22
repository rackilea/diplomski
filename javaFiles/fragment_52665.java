public class Record {
    public String name;
    public List<Field> fieldList;


    @XmlElementWrapper(name = "fieldList")
    // XmlElement sets the name of the entities in collection
    @XmlElement(name = "Field")
   public void setFieldList(List<Field> fieldList)
  {
    this.fieldList = fieldList;
  }


}