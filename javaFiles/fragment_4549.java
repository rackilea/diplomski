@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Variable.class,Parameter.class})
public class Contract{

     @XmlElement(name="Variable")
     @XmlJavaTypeAdapter(YourAdapter.class)
     private Map<String,String> map;

     @XmlElement(name="Parameter")
     @XmlJavaTypeAdapter(YourAdapterForParameter.class)
     private Map<String,String> parameterMap;

     public Long getId(){
          return Long.valueOf(parameterMap.get("id"));
     }

     public void setId(Long id){
          parameterMap.put("id",id.toString());
     }

     //Same thing for other getters/setters
}