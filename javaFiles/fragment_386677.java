@Entity
@Table(name = "valCurs")
@XmlRootElement(name="ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {    
...    
   @XmlElement(name = "Valute")
   @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
   private List<Valute> allValutes; //you should use List rather than ArrayList