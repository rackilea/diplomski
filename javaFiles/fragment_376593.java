@Entity
@NamedEntityGraph(name = "Dis.detail", 
attributeNodes = {@NamedAttributeNode("tipoValidazione"),
        @NamedAttributeNode("prodotto")})
@NamedQuery(name="Dis.findAll", query="SELECT d FROM Dis d")
public class Dis implements Serializable {